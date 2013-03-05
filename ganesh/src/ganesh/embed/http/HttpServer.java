package ganesh.embed.http;

import ganesh.embed.http.servlets.DebugServlet;
import ganesh.embed.http.servlets.E404Servlet;
import ganesh.embed.http.servlets.ImageServlet;
import ganesh.embed.http.servlets.InfoServlet;
import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class HttpServer {

	private static HttpServer instance;

	public static HttpServer getInstance() {
		if (instance == null)
			instance = new HttpServer();

		return instance;
	}

	private HttpServer() {};

	private Server server;

	public void startServer() throws GException {
		server = new Server(8833); //TODO botar esta porta em cfg.ini
		try {
			// Coleção de contextos
			RewriteHandler rewrite = new RewriteHandler();
			rewrite.setRewriteRequestURI(true);
			rewrite.setRewritePathInfo(true);
			rewrite.addRule(new HttpRewriteRule());

			ContextHandlerCollection col = new ContextHandlerCollection();

			ServletContextHandler sch = new ServletContextHandler();
			sch.addServlet(E404Servlet.class, "/404");
			sch.addServlet(ImageServlet.class, "/img");
			sch.addServlet(DebugServlet.class, "/debug");
			sch.addServlet(InfoServlet.class, "/info");

			col.addHandler(sch);

			rewrite.setHandler(col);
			server.setHandler(rewrite);

			server.start();
			server.join();
		} catch (Exception e) {
			throw new GException(ErrorCode.UNKOWN, "Não foi possivel iniciar o servidor http", e);
		}
	}

	public String getVersion() {
		return Server.getVersion();
	}
}
