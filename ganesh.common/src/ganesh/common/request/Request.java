/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.scharlessantos.hermes.Hermes;

public class Request {

	public void decode(HttpServletRequest original) throws GException {
		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLEventReader reader = factory.createXMLEventReader(original.getInputStream());

		} catch (XMLStreamException | IOException e) {
			Hermes.error(e);
			throw new GException(ErrorCode.XML_PARSE, e);
		}
	}

	public Response doRequest() {

		Response resp = new Response();
		try {
			URL url = new URL("http", "poseidon", 8833, "/login");

			HttpURLConnection connection = (HttpURLConnection)url.openConnection();

			connection.connect();

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

}
