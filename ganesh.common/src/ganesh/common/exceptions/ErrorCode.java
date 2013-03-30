/* Ganesh Commons, developed in 2013*/
package ganesh.common.exceptions;

public enum ErrorCode {

	UNKNOWN,

	DB_UPDATE,

	SQL_EXCEPTION,

	HTTP_SERVER_LOAD,

	XML_PARSE,

	//Aplicação
	ACESSO_NEGADO,

	DB_ERROR;

	@Override
	public String toString() {
		return String.format("(GANESH-%03d)", ordinal());
	};

}
