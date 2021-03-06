/* Ganesh Server, developed in 2013*/
package ganesh.exception;

import ganesh.common.exceptions.ErrorCode;

public enum ServerErrorCode implements ErrorCode {

	UNKNOWN,

	DB_UPDATE,

	SQL_EXCEPTION,

	HTTP_SERVER_LOAD,

	ACESSO_NEGADO,

	DB_ERROR, LOAD_CONFIG, INVALID_PARAM;

	@Override
	public String toString() {
		return String.format("(GANESH-%03d)", ordinal());
	};

}
