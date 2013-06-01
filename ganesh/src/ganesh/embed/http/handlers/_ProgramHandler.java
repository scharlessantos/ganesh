/* Ganesh Server, developed in 2013*/

package ganesh.embed.http.handlers;

import ganesh.Ganesh;
import ganesh.access.AccessControl;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;
import ganesh.common.session.SessionManager;
import ganesh.exception.ServerErrorCode;
import ganesh.programs.GaneshProgram;
import ganesh.programs.ProgramManager;
import ganesh.programs.ProgramManager.RequestType;
import ganesh.programs.RequestHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scharlessantos.hermes.Hermes;

public class _ProgramHandler implements _MyHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -777391001268902809L;

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh Program Thread");

		Response resp = new Response(response);
		Request req = new Request() {

			@Override
			protected void write(PrintWriter wr) {

			}

			@Override
			protected String getAction() {
				return null;
			}
		};

		try {
			req.decode(request);
			validateSession(req.getSession());
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.setResponseValue(Response.SESSAO_INVALIDA);
			resp.writeResponse();
			return;
		}

		SessionManager.setSession(req.getSession());

		resp.setSession(req.getSession());

		String[] params = target.split("/");

		if (params.length < 2) {
			Hermes.warn("Requisiçao " + target + " mal formada");
			resp.setMessage(new ErrorMessage("Requisição mal formada"));
		} else {

			try {
				String pname = params[0];
				String action = params[1];

				GaneshProgram program;

				program = ProgramManager.newProgram(pname);

				if (program == null) {
					Hermes.warn("Programa " + pname + " não registrado");
					resp.setMessage(new ErrorMessage("Programa \"" + pname + "\" não registrado"));
				} else {
					Thread.currentThread().setName("Ganesh Program " + pname + " Thread");

					RequestType type = getRequestType(action);

					if (type == null) {

						Hermes.warn("Ação " + action + " inválida");
						resp.setMessage(new ErrorMessage("Ação " + action + " inválida"));
					} else {
						Thread.currentThread().setName("Ganesh Program " + pname + " Thread: " + action);

						Method method = null;

						for (Method m: program.getClass().getMethods())
							if (m.isAnnotationPresent(RequestHandler.class))
								if (m.getAnnotation(RequestHandler.class).value().equals(type)) {
									method = m;
									break;
								}

						if (method == null) {
							Hermes.warn("Ação " + action + " não tratado em " + program.getClass().getName());
							resp.setMessage(new ErrorMessage("Ação " + action + " não tratada em " + program.getClass().getName()));
						} else {

							Class<?>[] mp = method.getParameterTypes();
							if (mp != null && mp.length > 0) {
								Object[] args = new Object[mp.length];

								for (int i = 0; i < mp.length; i++) {
									if (mp[i].equals(Request.class))
										args[i] = req;
									else if (mp[i].equals(Response.class))
										args[i] = resp;
									else if (mp[i].equals(Session.class))
										args[i] = req.getSession();
									else if (mp[i].equals(String.class)) {
										String extra = "";
										for (int j = 2; j < params.length; j++)
											extra += params[j] + "/";

										args[i] = extra;
									} else
										throw new GException(ServerErrorCode.INVALID_PARAM, Ganesh.getMessages()._naoEhUmParametroValido(mp[i].getSimpleName()));

								}

								method.invoke(program, args);
							} else
								method.invoke(program);
						}

					}

				}
			} catch (Exception e) {
				Hermes.error(e);
				resp.setMessage(new ErrorMessage(e.getMessage()));
			}
		}

		SessionManager.removeSession();

		resp.writeResponse();
	}

	private void validateSession(Session session) throws GException {
		if (session == null)
			throw new GException(ServerErrorCode.ACESSO_NEGADO, Ganesh.getMessages().sessaoInvalida());

		Session s = AccessControl.getInstance().getSession(session.getUuid());

		if (s == null)
			throw new GException(ServerErrorCode.ACESSO_NEGADO, Ganesh.getMessages().sessaoInvalida());

		s.update(session);
	}

	private RequestType getRequestType(String action) {

		switch (action) {
			case "save":
				return RequestType.SAVE;
			case "delete":
				return RequestType.DELETE;
			case "list":
				return RequestType.LIST;
		}

		return null;
	}
}
