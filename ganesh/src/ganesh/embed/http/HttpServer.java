/* Ganesh Server, developed in 2013*/
package ganesh.embed.http;

import exception.ServerErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.embed.http.handlers.HttpHandler;

import org.eclipse.jetty.server.Server;
import org.scharlessantos.hermes.Hermes;

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

			Hermes.info("Iniciado Serviço HTTP na porta %d (Jetty %s)", 8833, getVersion());

			server.join();

		} catch (Exception e) {
			throw new GException(ServerErrorCode.HTTP_SERVER_LOAD, "Não foi possivel iniciar o servidor http", e);
		}
	}

	public String getVersion() {
		return Server.getVersion();
	}
}
