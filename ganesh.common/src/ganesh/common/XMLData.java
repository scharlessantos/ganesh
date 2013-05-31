/* Ganesh Commons, developed in 2013 */
package ganesh.common;

import ganesh.common.exceptions.CommonErrorCode;
import ganesh.common.exceptions.GRuntimeException;

import java.util.HashMap;

public class XMLData extends HashMap<String, String> implements XMLItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -980132596612853144L;

	@Override
	public String toXML() {
		throw new GRuntimeException(CommonErrorCode.RESPONSE_DATA_TOXML);
	}

}
