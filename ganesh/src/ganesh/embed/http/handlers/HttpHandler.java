/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * @author charles
 */
public class HttpHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		target = target.substring(1);

		_MyHandler handler = null;

		if (target.isEmpty() || target.equals("info"))
			handler = new _InfoHandler();
		else if (target.equals("debug"))
			handler = new _DebugHandler();
		else if (target.startsWith("program")) {
			//TODO
		} else if (target.equals("login")) {
			//TODO
		} else if (target.startsWith("img/"))
			handler = new _ImageHandler();
		else
			handler = new _404Hanlder();

		handler.handle(target, request, response);

		baseRequest.setHandled(true);
	}
}
