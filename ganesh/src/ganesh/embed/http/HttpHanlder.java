package ganesh.embed.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.scharlessantos.hermes.Hermes;

public class HttpHanlder extends AbstractHandler {

	@Override
	public void handle(String arg0, Request baseReq, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setStatus(Response.SC_OK);
		baseReq.setHandled(true);
		resp.getWriter().println("Helo World");
	
		Hermes.info("Teste");
		
	}
}
