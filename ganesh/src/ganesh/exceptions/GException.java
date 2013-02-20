package ganesh.exceptions;

public class GException extends Exception{
	
	private static final long serialVersionUID = 7414687980700018664L;
	
	private ErrorCode code;
	
	public GException(ErrorCode code){
		this(code, "");
	}
	
	public GException(ErrorCode code, String message){
		this(code, message, null);
	}
	
	public GException(ErrorCode code, Throwable cause){
		this(code, null, cause);
	}
	
	public GException(ErrorCode code, String message, Throwable cause){
		super(message, cause);
		
		this.code = code;
	}
	
	public ErrorCode getCode(){
		return code;
	}
	
	public String getMessage() {
		return code.toString() + ": " + super.getMessage();
	};
}
