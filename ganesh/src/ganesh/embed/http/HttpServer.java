package ganesh.embed.http;

import ganesh.embed.http.handlers.HttpHandler;
import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

import org.eclipse.jetty.server.Server;

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
			server.setHandler(new HttpHandler());

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
