/* Ganesh Commons, developed in 2013 */
package ganesh.common.exceptions;

public enum CommonErrorCode implements ErrorCode {

	XML_PARSE, RESPONSE_DATA_TOXML

	;

	@Override
	public String toString() {
		return String.format("(GANESH-COM-%03d)", ordinal());
	};

}
