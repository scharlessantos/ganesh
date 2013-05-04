/* Ganesh Commons, developed in 2013 */
package ganesh.common.exceptions;

import ganesh.common.i18n.GString;

public class GRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7414687980700018664L;

	private ErrorCode code;

	private GString message;

	public GRuntimeException(ErrorCode code) {
		this(code, "", null);
	}

	public GRuntimeException(ErrorCode code, GString message) {
		this(code, message, null);
	}

	public GRuntimeException(ErrorCode code, Throwable cause) {
		this(code, "", cause);
	}

	public GRuntimeException(ErrorCode code, GString message, Throwable cause) {
		super(cause);

		this.code = code;
		this.message = message;
	}

	public GRuntimeException(ErrorCode code, String message) {
		this(code, message, null);
	}

	public GRuntimeException(ErrorCode code, String message, Throwable cause) {
		super(message, cause);

		this.code = code;
	}

	public ErrorCode getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return (code == null ? "" : code.toString() + ": ") + (message == null ? super.getMessage() : message.toString());
	}
}
