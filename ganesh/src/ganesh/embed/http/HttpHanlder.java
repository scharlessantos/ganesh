package ganesh.embed.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HttpHanlder extends AbstractHandler {

	@Override
	public void handle(String arg0, Request baseReq, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		baseReq.setHandled(true);
		resp.setHeader("<title>", "Ganesh Server");
		resp.getWriter().println("<h1>Ganesh Server says: It works!</h1><br>");
		resp.getWriter().println("_________________________________________________________________");
		resp.getWriter().println("<br><b>Powered by</b> <br> Http Server: Jetty " + HttpServer.getInstance().getVersion() + "<br> JVM: " + System.getProperty("java.version") + " from " + System.getProperty("java.vendor") + "<br>OS:  " + System.getProperty("os.name") + "_" + System.getProperty("os.version") + " arch " + System.getProperty("os.arch"));
	}
}
