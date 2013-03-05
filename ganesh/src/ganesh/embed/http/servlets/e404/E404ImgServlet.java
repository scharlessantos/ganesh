/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.servlets.e404;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Response;

public class E404ImgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4521677553354917841L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("img/png");

		InputStream is = getClass().getResourceAsStream("ganesh.png");
		byte[] read = new byte[1024];

		while (is.read(read) > 0)
			resp.getOutputStream().write(read);

		resp.setStatus(Response.SC_OK);
	}
}
