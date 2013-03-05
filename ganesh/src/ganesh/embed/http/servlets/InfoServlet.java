/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.servlets;

import ganesh.embed.http.HttpServer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

public class InfoServlet extends HttpServlet {

	private static final long serialVersionUID = -9176884431059970611L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		resp.getWriter().println("<h1>Ganesh Server says:</h1><br>");
		resp.getWriter().println("<img src=/img/itworks />");
		resp.getWriter().println(poweredBy());
	}

	public static String poweredBy() {
		return "<br><br>_____________________________________________________<small><i><br><b>Powered by</b> <br> Http Server: Jetty " + HttpServer.getInstance().getVersion() + "<br> JVM: " + System.getProperty("java.version") + " from " + System.getProperty("java.vendor") + "<br>OS:  " + System.getProperty("os.name") + "_" + System.getProperty("os.version") + " arch " + System.getProperty("os.arch") + "</i></small>";
	}
}
