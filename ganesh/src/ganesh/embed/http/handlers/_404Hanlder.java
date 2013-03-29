/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;
import org.scharlessantos.hermes.Hermes;

class _404Hanlder implements _MyHandler {

	private static final long serialVersionUID = -4398074280630642628L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Hermes.info("Not found /" + target);

		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head><title>Ganesh - Application Server</title></head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<center>");
		resp.getWriter().println("<font size=9 color=red><i><b>Ops!<br></b></i></font>");
		resp.getWriter().println("<font size=3><i><b>Ganesh não conseguiu resolver este problema<br></b></i></font>");
		resp.getWriter().println("<img src=/img/e404 />");
		resp.getWriter().println("<font size=2 color=red><i><br>Erro 404 - Não foi possível encontrar <b>/" + target + "</b></i></font>");
		resp.getWriter().println("</center>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

		resp.getWriter().println(_InfoHandler.poweredBy());
		resp.setStatus(Response.SC_NOT_FOUND);
	}
}
