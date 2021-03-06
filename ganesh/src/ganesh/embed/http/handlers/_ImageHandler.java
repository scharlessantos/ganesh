/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

class _ImageHandler implements _MyHandler {

	private static final long serialVersionUID = -2514879867408587001L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh get Image Thread");

		InputStream is = getClass().getResourceAsStream("images/" + target + (target.endsWith(".ico") ? "" : ".png"));

		if (is == null)
			new _404Hanlder().handle("</b> a imagem: <b>" + target, req, resp);
		else {
			if (target.endsWith(".ico"))
				resp.setContentType("image/ico");
			else
				resp.setContentType("image/png");

			byte[] read = new byte[1024];

			while (is.read(read) > 0)
				resp.getOutputStream().write(read);

			resp.setStatus(Response.SC_OK);
		}

	}
}
