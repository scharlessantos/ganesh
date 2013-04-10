/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.programs;

import ganesh.common.exceptions.GException;
import ganesh.swing.GaneshSwing;
import ganesh.swing.exceptions.ClientErrorCode;
import ganesh.swing.i18n.Messages;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public final class GaneshData {

	private Messages M = GaneshSwing.getMessages();

	private HashMap<String, Object> mydata = new HashMap<>();

	private void setObject(String key, Object value) throws GException {
		if (key == null)
			throw new GException(ClientErrorCode.INVALID_DATA_SET, M.chaveInvalida());

		mydata.put(key, value);
	}

	public void setInteger(String key, Integer value) throws GException {
		setObject(key, value);
	}

	public void setString(String key, String value) throws GException {
		setObject(key, value);
	}

	public void setDouble(String key, Double value) throws GException {
		setObject(key, value);
	}

	public void setFloat(String key, Float value) throws GException {
		setObject(key, value);
	}

	public void setShort(String key, Short value) throws GException {
		setObject(key, value);
	}

	public void setDate(String key, Date value) throws GException {
		setObject(key, value);
	}

	public void setGaneshDataList(String key, List<GaneshData> value) throws GException {
		setObject(key, value);
	}

	public Integer setInteger(String key) {
		if (mydata.get(key) instanceof Integer)
			return (Integer)mydata.get(key);

		return null;
	}

	public String setString(String key) {
		if (mydata.get(key) instanceof String)
			return (String)mydata.get(key);

		return null;
	}

	public Double setDouble(String key) {
		if (mydata.get(key) instanceof Double)
			return (Double)mydata.get(key);

		return null;
	}

	public Float setFloat(String key) {
		if (mydata.get(key) instanceof Float)
			return (Float)mydata.get(key);

		return null;
	}

	public Short setShort(String key) {
		if (mydata.get(key) instanceof Short)
			return (Short)mydata.get(key);

		return null;
	}

	public Date setDate(String key) {
		if (mydata.get(key) instanceof Date)
			return (Date)mydata.get(key);

		return null;
	}

	public Timestamp setTimestamp(String key) {
		if (mydata.get(key) instanceof Timestamp)
			return (Timestamp)mydata.get(key);

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<GaneshData> getGaneshDataList(String key) throws GException {
		if (mydata.get(key) instanceof List<?>)
			return (List<GaneshData>)mydata.get(key);

		return null;

	}
}
