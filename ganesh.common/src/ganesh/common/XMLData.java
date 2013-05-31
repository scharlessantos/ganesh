/* Ganesh Commons, developed in 2013 */
package ganesh.common;

import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GRuntimeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLData extends HashMap<String, String> implements XMLItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -980132596612853144L;

	private Map<String, List<XMLData>> items = new HashMap<>();

	public void add(String key, XMLData data) {
		List<XMLData> list = items.get(key);

		if (list == null)
			list = new ArrayList<>();

		list.add(data);

		items.put(key, list);
	}

	public List<XMLData> getList(String key) {
		List<XMLData> list = items.get(key);

		if (list == null)
			return null;

		return new ArrayList<>(list);
	}

	public Collection<String> getItens() {
		return items.keySet();
	}

	@Override
	public String toXML() {
		throw new GRuntimeException(CommonErrorCode.RESPONSE_DATA_TOXML);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("XMLData: ");

		for (String key: keySet()) {
			sb.append(key);
			sb.append("=");
			sb.append(get(key));
			sb.append("; ");
		}

		sb.append("items[");

		for (String key: items.keySet()) {
			sb.append(key);
			sb.append("={");
			sb.append(items.get(key));
			sb.append("}; ");

		}

		sb.append("]");

		return sb.toString();
	}
}
