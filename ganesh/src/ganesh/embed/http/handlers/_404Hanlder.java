/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

class _404Hanlder implements _MyHandler {

	private static final long serialVersionUID = -4398074280630642628L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		resp.getWriter().println("<center>");
		resp.getWriter().println("<font size=6 color=red><i><b>Erro Interno<br></b></i></font>");
		resp.getWriter().println("<img src=/img/e404 />");
		resp.getWriter().println("<font size=2 color=red><i><br>Erro 404 - Não foi possível encontrar <b>" + target + "</b></i></font>");
		resp.getWriter().println("</center>");

		resp.getWriter().println(_InfoHandler.poweredBy());
		resp.setStatus(Response.SC_NOT_FOUND);
	}

}
