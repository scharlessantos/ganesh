package ganesh.embed.http;

import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.embed.http.handlers.GaneshHttpThreadPool;
import ganesh.embed.http.handlers.HttpHandler;

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
			server.setThreadPool(new GaneshHttpThreadPool());
			server.setHandler(new HttpHandler());

			server.start();
			server.join();
		} catch (Exception e) {
			throw new GException(ErrorCode.HTTP_SERVER_LOAD, "Não foi possivel iniciar o servidor http", e);
		}
	}

	public String getVersion() {
		return Server.getVersion();
	}
}
