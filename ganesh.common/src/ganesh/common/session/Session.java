/* Ganesh Commons, developed in 2013*/
package ganesh.common.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

	@Override
	public boolean equals(Object other) {
		if (other instanceof Session)
			return ((Session)other).getUuid().equals(uuid);

		return false;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Session copy() {
		return new Session(this);
	}

	public void update(Session session) {
		synchronized (this) {
			for (Entry<String, String> e: session.properties.entrySet()) {
				String s = properties.get(e.getKey());

				if (s != null && !s.equals(e.getValue()))
					properties.put(e.getKey(), e.getValue());
			}
		}
	}

	public String toXML() {
		String xml = "<session uuid='" + uuid + "' language='" + language.toString() + "'>\n";

		for (String key: properties.keySet())
			xml += "<property key='" + key + "' value='" + properties.get(key) + "' />\n";

		return xml + "</session>";
	}

}
