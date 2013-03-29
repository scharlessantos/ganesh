/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import ganesh.embed.http.HttpServer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

class _InfoHandler implements _MyHandler {

	private static final long serialVersionUID = 5557429817678778174L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh Info Thread");

		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head><title>Ganesh - Application Server</title></head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>Ganesh Server says:</h1><br>");
		resp.getWriter().println("<img src=/img/itworks />");
		resp.getWriter().println(poweredBy());
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

	public static String poweredBy() {
		return "<br><br>_____________________________________________________<small><i><br><b>Powered by</b> <br> Http Server: Jetty " + HttpServer.getInstance().getVersion() + "<br> JVM: " + System.getProperty("java.version") + " from " + System.getProperty("java.vendor") + "<br>OS:  " + System.getProperty("os.name") + "_" + System.getProperty("os.version") + " arch " + System.getProperty("os.arch") + "</i></small>";
	}

}
