package ganesh.common.session;

import java.io.Serializable;
import java.util.Properties;

public class Session implements Serializable {

	private static final long serialVersionUID = -2160462203741490866L;

	private Properties properties = new Properties();
	
	public void addProperty(String key, String value){
		properties.put(key, value);
	}
	
	public void removeProperty(String key){
		properties.remove(key);
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	
	public String toXML(){
		return null;
	}
}
