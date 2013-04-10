/* Ganesh Commons, developed in 2013 */
package ganesh.common.exceptions;

public enum CommonErrorCode implements ErrorCode {

	XML_PARSE

	;

	@Override
	public String toString() {
		return String.format("(GANESH-%03d)", ordinal());
	};

}
