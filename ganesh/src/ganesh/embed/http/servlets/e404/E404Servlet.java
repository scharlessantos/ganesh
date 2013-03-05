/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.servlets.e404;

import ganesh.embed.http.servlets.InfoServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

public class E404Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4415867880237424462L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		resp.getWriter().println("<center>");
		resp.getWriter().println("<img src=/img/e404 />");
		resp.getWriter().println("<font size=2 color=red><i><br>Não foi possível encontrar <b>" + req.getAttribute("target") + "</b></i></font>");
		resp.getWriter().println("</center>");

		resp.getWriter().println(InfoServlet.poweredBy());
		resp.setStatus(Response.SC_NOT_FOUND);
	}
}
