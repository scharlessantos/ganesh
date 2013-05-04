/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.scharlessantos.hermes.Hermes;

public abstract class Request {

	public void decode(HttpServletRequest original) throws GException {
		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLEventReader reader = factory.createXMLEventReader(original.getInputStream());

		} catch (XMLStreamException | IOException e) {
			Hermes.error(e);
			throw new GException(CommonErrorCode.XML_PARSE, e);
		}
	}

	public Response doRequest() {

		Response resp = new Response();
		try {
			String action = getAction();
			if (action == null)
				return null;

			URL url = new URL("http", System.getProperty("ganesh.server.address", "localhost"), Integer.parseInt(System.getProperty("ganesh.server.port", "8833")), "/" + getAction());

			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);

			connection.connect();

			write(new PrintWriter(connection.getOutputStream()));

			resp.decode(connection.getInputStream());

			connection.disconnect();

		} catch (GException | IOException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
		}

		return resp;
	}

	private Session session;

	public Session getSession() {
		return session;
	}

	public Request setSession(Session session) {
		this.session = session;
		return this;
	}

	protected abstract String getAction();

	protected abstract void write(PrintWriter wr);

}
