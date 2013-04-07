/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import ganesh.Ganesh;
import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.common.request.LoginRequest;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;
import ganesh.db.Usuario;

import java.io.IOException;
import java.util.UUID;

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
				resp.setMessage(new ErrorMessage(Ganesh.getMessages().usuarioSenhaInvalido()));
			} else {
				Session session = new Session(UUID.randomUUID().toString(), req.getLanguage());
				resp.setSession(session);
				resp.setMessage(new InformationMessage("Sucesso!!! //TODO"));
			}

		} catch (GException e) {
			resp.setMessage(new ErrorMessage(Ganesh.getMessages().requisicaoInvalida()));
			Hermes.error(e);
		}

		resp.writeResponse();
	}
}
