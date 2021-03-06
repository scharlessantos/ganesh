/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import ganesh.Ganesh;
import ganesh.access.AccessControl;
import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.common.request.LoginRequest;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;
import ganesh.db.Usuario;
import ganesh.exception.ServerErrorCode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scharlessantos.hermes.Hermes;

public class _LoginHandler implements _MyHandler {

	private static final long serialVersionUID = -8789409316228537279L;

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh Login Thread");

		Response resp = new Response(response);

		LoginRequest req = new LoginRequest();
		try {
			req.decode(request);
			GaneshI18n.setLanguage(req.getLanguage());

			Usuario usuario = Usuario.getByUsername(req.getUsername());

			if (usuario == null || !usuario.checkPassword(req.getPassword())) {
				resp.setResponseValue(Response.ACESSO_NEGADO);
				resp.setMessage(new ErrorMessage(ServerErrorCode.ACESSO_NEGADO.toString() + ": " + Ganesh.getMessages().usuarioSenhaInvalido()));
			} else {
				Session session = AccessControl.getInstance().newSession(req.getLanguage());
				session.addProperty("username", usuario.getUsername());
				session.addProperty("pessoa.nome", usuario.getNome());
				resp.setSession(session);

			}

		} catch (GException e) {
			resp.setMessage(new ErrorMessage(Ganesh.getMessages().requisicaoInvalida()));
			Hermes.error(e);
		}

		resp.writeResponse();
	}
}
