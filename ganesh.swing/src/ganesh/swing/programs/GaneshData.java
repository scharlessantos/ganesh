/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs;

import ganesh.common.exceptions.GRuntimeException;
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

	private void setObject(String key, Object value) {
		if (key == null)
			throw new GRuntimeException(ClientErrorCode.INVALID_DATA_SET, M.chaveInvalida());

		mydata.put(key, value);
	}

	public void setInteger(String key, Integer value) {
		setObject(key, value);
	}

	public void setString(String key, String value) {
		setObject(key, value);
	}

	public void setDouble(String key, Double value) {
		setObject(key, value);
	}

	public void setFloat(String key, Float value) {
		setObject(key, value);
	}

	public void setShort(String key, Short value) {
		setObject(key, value);
	}

	public void setDate(String key, Date value) {
		setObject(key, value);
	}

	public void setGaneshDataList(String key, List<GaneshData> value) {
		setObject(key, value);
	}

	public Integer getInteger(String key) {
		if (mydata.get(key) instanceof Integer)
			return (Integer)mydata.get(key);

		return null;
	}

	public String getString(String key) {
		if (mydata.get(key) instanceof String)
			return (String)mydata.get(key);

		return null;
	}

	public Double getDouble(String key) {
		if (mydata.get(key) instanceof Double)
			return (Double)mydata.get(key);

		return null;
	}

	public Float getFloat(String key) {
		if (mydata.get(key) instanceof Float)
			return (Float)mydata.get(key);

		return null;
	}

	public Short getShort(String key) {
		if (mydata.get(key) instanceof Short)
			return (Short)mydata.get(key);

		return null;
	}

	public Date getDate(String key) {
		if (mydata.get(key) instanceof Date)
			return (Date)mydata.get(key);

		return null;
	}

	public Timestamp getTimestamp(String key) {
		if (mydata.get(key) instanceof Timestamp)
			return (Timestamp)mydata.get(key);

		return null;
	}

	public Object get(String key) {
		return mydata.get(key);
	}

	@SuppressWarnings("unchecked")
	public List<GaneshData> getGaneshDataList(String key) {
		if (mydata.get(key) instanceof List<?>)
			return (List<GaneshData>)mydata.get(key);

		return null;

	}
}
