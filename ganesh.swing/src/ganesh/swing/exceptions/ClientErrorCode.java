/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.exceptions;

import ganesh.common.exceptions.ErrorCode;

public enum ClientErrorCode implements ErrorCode {

	INVALID_DATA_SET,

	UI,

	PROGRAM_NOT_REGISTERED;

	@Override
	public String toString() {
		return String.format("(GANESH-CLI-%03d)", ordinal());
	};

}
