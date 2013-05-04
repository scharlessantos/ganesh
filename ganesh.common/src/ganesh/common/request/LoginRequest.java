/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GException;

import java.io.IOException;
import java.io.PrintWriter;

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

public class LoginRequest extends Request {

	private String username = null;
	private String password = null;
	private Language lang = null;

	public LoginRequest() {}

	public LoginRequest(String usuario, String senha, Language lang) {
		this.username = usuario;
		this.password = senha;
		this.lang = lang;
	}

	@Override
	public void decode(HttpServletRequest original) throws GException {
		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLEventReader reader = factory.createXMLEventReader(original.getInputStream());

			while (reader.hasNext()) {

				XMLEvent event = reader.nextEvent();

				switch (event.getEventType()) {
					case XMLEvent.START_ELEMENT:
						StartElement se = event.asStartElement();

						if (se.getName().getLocalPart().equals("login")) {
							Attribute a = se.getAttributeByName(new QName("username"));

							if (a != null)
								username = a.getValue();

							a = se.getAttributeByName(new QName("password"));

							if (a != null)
								password = a.getValue();

							a = se.getAttributeByName(new QName("language"));

							if (a != null)
								lang = Language.getByAcronym(a.getValue());
						}

						break;
					case XMLEvent.END_ELEMENT:

						break;
				}

			}

		} catch (XMLStreamException | IOException e) {
			Hermes.error(e);
			throw new GException(CommonErrorCode.XML_PARSE, e);
		}
	}

	@Override
	protected void write(PrintWriter wr) {
		wr.println("<?xml version='1.0' ?>");
		wr.println("<request>");
		wr.println("<login username='" + username + "' password='" + password + "' language='" + lang.toString() + "'/>");
		wr.println("</request>");
		wr.flush();

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Language getLanguage() {
		return lang;
	}

	@Override
	protected String getAction() {
		return "login";
	}

}
