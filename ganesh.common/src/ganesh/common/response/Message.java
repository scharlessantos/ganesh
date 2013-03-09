/* Ganesh Commons, developed in 2013 */
package ganesh.common.response;

public class Message {

	public static final short ICON_INFORMATION = 0;
	public static final short ICON_CONFIRMATION = 1;
	public static final short ICON_WARNING = 2;
	public static final short ICON_ERROR = 3;

	public static final short BUTTON_OK = 0;
	public static final short BUTTON_OKCANCEL = 1;
	public static final short BUTTON_OKCANCELRETRY = 2;
	public static final short BUTTON_YESNO = 3;
	public static final short BUTTON_YESNOCANCEL = 4;

	private String message;
	private short buttons;
	private short icon;

	public Message(String message, short icon, short buttons) {
		this.message = message;
		this.buttons = buttons;
		this.icon = icon;
	}

	public String getMessage() {
		return message;
	}

	public short getButtons() {
		return buttons;
	}

	public short getType() {
		return icon;
	}

	@Override
	public String toString() {
		return "Mensagem[message=" + message + ";buttons=" + buttons + ";icon=" + icon + "]";
	}

	public String toXML() {
		return "<message message='" + message + "' buttons='" + buttons + "' icon='" + icon + "' />";
	}

	public static class InformationMessage extends Message {

		public InformationMessage(String message) {
			super(message, ICON_INFORMATION, BUTTON_OK);
		}

	}

	public static class WarningMessage extends Message {

		public WarningMessage(String message) {
			super(message, ICON_WARNING, BUTTON_OK);
		}
	}

	public static class ErrorMessage extends Message {

		public ErrorMessage(String message) {
			super(message, ICON_ERROR, BUTTON_OK);
		}
	}

	public static class ConfirmationMessage extends Message {

		public ConfirmationMessage(String message) {
			super(message, ICON_CONFIRMATION, BUTTON_YESNO);
		}
	}
}
