/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.exceptions;

import ganesh.common.exceptions.ErrorCode;

public enum ClientErrorCode implements ErrorCode {

	DB_ERROR,

	INVALID_DATA_SET;

	@Override
	public String toString() {
		return String.format("(GANESH-%03d)", ordinal());
	};

}
