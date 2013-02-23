package ganesh.embed.http;

import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

import org.eclipse.jetty.server.Server;

public class HttpServer {

	
	private static HttpServer instance;
	
	public static HttpServer getInstance(){
		if (instance==null)
			instance = new HttpServer();
		
		return instance;
	}
	
	private HttpServer(){};
	
	private Server server;
	
	public void startServer() throws GException{
		server = new Server(8833);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			throw new GException(ErrorCode.UNKOWN, "Não foi possivel iniciar o servidor http", e);
		}
	}
	
}
