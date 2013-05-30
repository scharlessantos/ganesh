/*Ganesh Swing Client, developed in 2013*/
package ganesh.swing.ui;

import ganesh.common.response.Message;
import ganesh.swing.GaneshSwing;

import javax.swing.JOptionPane;

public class MessageHandler {

	public static void show(Message message) {
		JOptionPane.showMessageDialog(null, message.getMessage(), message.getTitle() == null ? getTitle(message.getIcon()) : message.getTitle(), getMessageType(message.getIcon()));
	}

	private static String getTitle(short icon) {
		switch (icon) {
			case Message.ICON_ERROR:
				return GaneshSwing.getMessages().erro();

			default:
				return GaneshSwing.getMessages().aviso();
		}

	}

	private static int getMessageType(short icon) {
		switch (icon) {
			case Message.ICON_ERROR:
				return JOptionPane.ERROR_MESSAGE;
			case Message.ICON_CONFIRMATION:
				return JOptionPane.QUESTION_MESSAGE;
			case Message.ICON_WARNING:
				return JOptionPane.WARNING_MESSAGE;
			default:
				return JOptionPane.INFORMATION_MESSAGE;
		}
	}
}
