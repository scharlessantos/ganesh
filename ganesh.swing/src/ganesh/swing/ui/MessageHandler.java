/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.swing.ui;

import ganesh.common.response.Message;

import javax.swing.JOptionPane;

public class MessageHandler {

	public static void show(Message message) {
		JOptionPane.showMessageDialog(null, message.getMessage(), "Aviso", getMessageType(message.getIcon()));
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
