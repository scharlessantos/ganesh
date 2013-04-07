/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.swing.GaneshSwing;
import ganesh.swing.ui.images.Images;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.scharlessantos.atlas.Language;

public class I18nButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2035243180769481594L;

	private Language language;

	public I18nButton(Language language) {
		super("");
		setToolTipText(language.getDescripton());
		setIcon(Images.getFlag(language.getAcronym()));

		//Evento clicar
		addActionListener(new MyAction());

		this.language = language;
	}

	public Language getLanguage() {
		return language;
	}

	private class MyAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			GaneshSwing.setLanguage(I18nButton.this.language);
		}

	}
}
