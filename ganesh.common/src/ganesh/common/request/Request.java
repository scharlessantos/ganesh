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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

public abstract class Request {

	public void decode(HttpServletRequest original) throws GException {
		try {

			if (original.getInputStream() == null)
				return;

			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLEventReader reader = factory.createXMLEventReader(original.getInputStream());

			List<String> parents = new ArrayList<>();

			while (reader.hasNext()) {

				XMLEvent event = reader.nextEvent();

				switch (event.getEventType()) {
					case XMLEvent.START_ELEMENT:
						StartElement se = event.asStartElement();
						parents.add(0, se.getName().getLocalPart());

						switch (parents.get(0)) {
							case "session":
								String uuid = "";
								if (se.getAttributeByName(new QName("uuid")) != null)
									uuid = se.getAttributeByName(new QName("uuid")).getValue();

								Language lang = null;
								if (se.getAttributeByName(new QName("language")) != null)
									lang = Language.getByAcronym(se.getAttributeByName(new QName("language")).getValue());

								session = new Session(uuid, lang);
								break;
							case "property":
								if (parents.size() > 1 && parents.get(1).equals("session")) {
									session.addProperty(se.getAttributeByName(new QName("key")).getValue(), se.getAttributeByName(new QName("value")).getValue());
								}
								break;
							default:

								break;
						}

						break;
					case XMLEvent.END_ELEMENT:
						parents.remove(0);
						break;
				}

			}

		} catch (XMLStreamException | IOException e) {
			Hermes.error(e);
			throw new GException(CommonErrorCode.XML_PARSE, "Bad Request");
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

			PrintWriter wr = new PrintWriter(connection.getOutputStream());
			wr.println("<?xml version='1.0' ?>");
			wr.println("<request>");

			if (getSession() != null)
				wr.println(session.toXML());

			write(wr);
			wr.println("\n</request>");
			wr.flush();

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
