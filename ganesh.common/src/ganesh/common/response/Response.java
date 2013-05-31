/* Ganesh Commons, developed in 2013 */
package ganesh.common.response;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.session.Session;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

public class Response {

	private HttpServletResponse original;

	public Response() {}

	public void decode(InputStream in) throws GException {

		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLEventReader reader = factory.createXMLEventReader(in);

			List<String> parents = new ArrayList<>();

			while (reader.hasNext()) {

				XMLEvent event = reader.nextEvent();

				switch (event.getEventType()) {
					case XMLEvent.START_ELEMENT:
						StartElement se = event.asStartElement();
						parents.add(0, se.getName().getLocalPart());

						switch (parents.get(0)) {
							case "response":
								break;

							case "message":
								message = new Message(se.getAttributeByName(new QName("message")).getValue(), new Short(se.getAttributeByName(new QName("icon")).getValue()).shortValue(), new Short(se.getAttributeByName(new QName("icon")).getValue()).shortValue());
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
							default:

								XMLData data = new XMLData();

								@SuppressWarnings("unchecked")
								Iterator<Attribute> attributes = se.getAttributes();
								while (attributes.hasNext()) {
									Attribute a = attributes.next();

									data.put(a.getName().getLocalPart(), a.getValue());
								}

								if (parents.size() > 2 && parents.get(2).equals("lists")) {
									addListItem(parents.get(1), data);
								} else {
									addListItem("list", data);
								}

								break;
						}

						break;
					case XMLEvent.END_ELEMENT:
						parents.remove(0);
						break;
				}

			}

		} catch (XMLStreamException e) {
			Hermes.error(e);
			throw new GException(CommonErrorCode.XML_PARSE, "Bad Response");
		}
	}

	public Response(HttpServletResponse original) {
		this.original = original;
	}

	public void write404Response() {
		original.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	private Message message;

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void writeResponse() throws IOException {
		original.setStatus(HttpServletResponse.SC_OK);
		original.setContentType("text/xml");

		PrintWriter wr = original.getWriter();

		wr.println("<?xml version='1.0' ?>");
		wr.println("<response>");

		if (session != null)
			wr.println(session.toXML());

		if (message != null)
			wr.println(message.toXML());

		if (!lists.isEmpty()) {
			wr.println("<lists>");

			for (String name: lists.keySet()) {
				wr.println("<" + name + ">");

				for (XMLItem item: lists.get(name))
					wr.println(item.toXML());

				wr.println("</" + name + ">");
			}

			wr.println("</lists>");
		}
		wr.println("</response>");
	}

	Map<String, List<XMLItem>> lists = new HashMap<String, List<XMLItem>>();

	public void addListItem(String name) {
		if (!lists.containsKey(name)) {
			lists.put(name, new ArrayList<XMLItem>());
		}
	}

	public void addListItem(String name, XMLItem item) {
		addListItem(name);
		lists.get(name).add(item);
	}

	public List<XMLItem> getList(String name) {
		addListItem(name);
		return new ArrayList<>(lists.get(name));

	}
}
