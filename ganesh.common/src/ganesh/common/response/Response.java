/* Ganesh Commons, developed in 2013 */
package ganesh.common.response;

import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.session.Session;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

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

						if (parents.get(0).equals("message")) {
							message = new Message(se.getAttributeByName(new QName("message")).getValue(), new Short(se.getAttributeByName(new QName("icon")).getValue()).shortValue(), new Short(se.getAttributeByName(new QName("icon")).getValue()).shortValue());
						}

						break;
					case XMLEvent.END_ELEMENT:

						break;
				}

			}

		} catch (XMLStreamException e) {
			Hermes.error(e);
			throw new GException(ErrorCode.XML_PARSE, "Response mal formada");
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

				for (ResponseItem item: lists.get(name))
					wr.println(item.toXML());

				wr.println("</" + name + ">");
			}

			wr.println("</lists>");
		}
		wr.println("</response>");
	}

	Map<String, List<ResponseItem>> lists = new HashMap<String, List<ResponseItem>>();

	public void addListItem(String name) {
		if (!lists.containsKey(name)) {
			lists.put(name, new ArrayList<ResponseItem>());
		}
	}

	public void addListItem(String name, ResponseItem item) {
		addListItem(name);
		lists.get(name).add(item);
	}

	public List<ResponseItem> getList(String name) {
		addListItem(name);
		return new ArrayList<>(lists.get(name));

	}
}