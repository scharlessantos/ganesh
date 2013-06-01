/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.XMLData;
import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.request.RequestFilter.JoinType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.common.session.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
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
							case "request":
								break;

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
							case "filter":
								String field = null;
								if (se.getAttributeByName(new QName("field")) != null)
									field = se.getAttributeByName(new QName("field")).getValue();

								String valor = null;
								if (se.getAttributeByName(new QName("value")) != null)
									valor = se.getAttributeByName(new QName("value")).getValue();

								FilterType type = null;
								if (se.getAttributeByName(new QName("type")) != null)
									type = FilterType.getByAcronym(se.getAttributeByName(new QName("type")).getValue());

								RequestFilter filter = new RequestFilter(field, valor, type);

								if (parents.get(1).equals("join") && joinAux.size() > 0 && filters.size() > 0)
									filters.get(0).join(joinAux.get(0), filter);
								else
									filters.add(0, filter);

								break;

							case "join":
								if (se.getAttributeByName(new QName("type")) != null) {
									JoinType join = JoinType.getByType(se.getAttributeByName(new QName("type")).getValue());

									if (join != null)
										joinAux.add(0, join);

								}

								break;
							default:

								XMLData data = new XMLData();

								@SuppressWarnings("unchecked")
								Iterator<Attribute> attributes = se.getAttributes();
								while (attributes.hasNext()) {
									Attribute a = attributes.next();

									data.put(a.getName().getLocalPart(), a.getValue());
								}

								if (parents.size() > 2 && items.size() > 0) {
									XMLData d = items.get(0);

									if (d == null)
										items.add(d);
									else
										d.add(parents.get(1), data);

								} else
									items.add(0, data);

								break;
						}

						break;
					case XMLEvent.END_ELEMENT:
						switch (parents.get(0)) {
							case "join":
								joinAux.remove(0);
								break;
						}
						parents.remove(0);
						break;
				}

			}

		} catch (XMLStreamException | IOException e) {
			Hermes.error(e);
			throw new GException(CommonErrorCode.XML_PARSE, "Bad Request");
		}
	}

	private List<JoinType> joinAux = new ArrayList<>();

	private List<XMLData> items = new ArrayList<>();

	private List<RequestFilter> filters = new ArrayList<>();

	public void addFilter(RequestFilter filter) {
		if (filter != null)
			filters.add(filter);
	}

	public List<RequestFilter> listFilters() {
		return new ArrayList<>(filters);
	}

	public List<XMLData> listItems() {
		return new ArrayList<>(items);
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

			if (filters.size() > 0)
				for (RequestFilter f: filters)
					wr.println(f.toXML());

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
