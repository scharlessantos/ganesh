package ganesh.common.exceptions;

public enum ErrorCode {

	UNKOWN;
	
	public String toString() {
		return String.format("(GANESH-%03d)", ordinal());
	};
	
}
