/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import exception.ServerErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;
import ganesh.common.session.SessionManager;
import ganesh.programs.GaneshProgram;
import ganesh.programs.ProgramManager;
import ganesh.programs.ProgramManager.RequestType;
import ganesh.programs.RequestHandler;

import java.io.IOException;
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
		Request req = new Request();

		try {
			req.decode(request);
			validateSession(req.getSession());
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.writeResponse();
			return;
		}

		SessionManager.setSession(req.getSession());

		resp.setSession(req.getSession());

		String[] params = target.split("/");

		if (params.length != 2) {
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

							//TODO: callMethod
							resp.setMessage(new InformationMessage("A implementar"));
						}
					}

				}
			} catch (GException | RuntimeException e) {
				Hermes.error(e);
				resp.setMessage(new ErrorMessage(e.getMessage()));
			}
		}

		SessionManager.removeSession();

		resp.writeResponse();
	}

	private void validateSession(Session session) throws GException {
		if (session == null)
			throw new GException(ServerErrorCode.ACESSO_NEGADO, "Sessão inválida");
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
