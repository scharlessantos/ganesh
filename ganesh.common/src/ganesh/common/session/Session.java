/* Ganesh Commons, developed in 2013*/
package ganesh.common.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.scharlessantos.atlas.Language;

public class Session implements Serializable {

	private static final long serialVersionUID = -2160462203741490866L;
	private Language language;

	private String uuid;
	private Map<String, String> properties = new HashMap<String, String>();

	public Session(String uuid, Language language) {
		this.uuid = uuid;
		this.language = language;
	}

	public Session(Session session) {
		this.properties = new HashMap<String, String>(session.properties);
		this.uuid = session.uuid;
		this.language = session.language;
	}

	public void addProperty(String key, String value) {
		properties.put(key, value);
	}

	public void removeProperty(String key) {
		properties.remove(key);
	}

	public String getProperty(String key) {
		return properties.get(key);
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Session copy() {
		return new Session(this);
	}

	public String toXML() {
		String xml = "<session uuid='" + uuid + "' language='" + language.toString() + "'>\n";

		for (String key: properties.keySet())
			xml += "\n<property key='" + key + "' value='" + properties.get(key) + "' />";

		return xml + "\n</session>";
	}
}
