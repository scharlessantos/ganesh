/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class _DebugHandler implements _MyHandler {

	private static final long serialVersionUID = 3726373459685376961L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("Debug");
		resp.getWriter().println(_InfoHandler.poweredBy());
	}

}
