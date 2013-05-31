/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.swing.GaneshSwing;
import ganesh.swing.ui.images.Images.Flags;

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
		this(language, false);
	}

	public I18nButton(Language language, boolean bigger) {
		super("");
		setToolTipText(language.getAcronym() + ": " + language.getDescripton());
		setIcon(Flags.get(language.getAcronym().toLowerCase() + (bigger ? "_2" : "")));

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
