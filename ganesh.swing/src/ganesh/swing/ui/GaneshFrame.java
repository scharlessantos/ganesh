/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.I18nListener;
import ganesh.swing.i18n.Messages;

import javax.swing.JFrame;

public abstract class GaneshFrame extends JFrame implements I18nListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6589181916995529141L;

	protected static final Messages M = GaneshSwing.getMessages();
}