/* Ganesh Commons, developed in 2013*/
package ganesh.common.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Session implements Serializable {

	private static final long serialVersionUID = -2160462203741490866L;

	private String uuid;
	private Map<String, String> properties = new HashMap<String, String>();

	public Session(String uuid) {
		this.uuid = uuid;
	}

	public Session(Session session) {
		this.properties = new HashMap<String, String>(session.properties);
		this.uuid = session.uuid;
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

	public Session copy() {
		return new Session(this);
	}

	public String toXML() {
		String xml = "<session uuid='" + uuid + "' >\n";

		for (String key: properties.keySet())
			xml += "\n<property key='" + key + "' value='" + properties.get(key) + "' />";

		return xml + "\n</session>";
	}
}
