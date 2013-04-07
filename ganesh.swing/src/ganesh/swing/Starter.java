/*Ganesh Swing Client, developed in 2013*/
package ganesh.swing;

import ganesh.common.i18n.GaneshI18n;
import ganesh.swing.ui.login.Login;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

/**
 * 
 */
public class Starter {

	/**
	 * Inicia o GANESH Swing Client
	 */
	public static void main(String[] args) {
		Hermes.info("" +
			"\n=====================================" +
			"\n    Starting Ganesh Swing Client" +
			"\n An open source program: NO WARRANTY" +
			"\n=====================================");

		try {
			Hermes.info("NimbusLookAndFeel");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			Hermes.warn("No nimbus look and feel");
		}

		GaneshI18n.loadTranslations(Language.PT_BR, Starter.class.getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
		GaneshI18n.loadTranslations(Language.EN_US, Starter.class.getResourceAsStream("i18n/translations/messages.en_US.trd"));

		GaneshSwing.setLanguage(Language.PT_BR);

		GaneshStart start = new GaneshStart();
		start.setName("Ganesh Start Thread");
		start.start();

	}

	private static class GaneshStart extends GaneshThread {

		private Login login;

		@Override
		public void realRun() {
			if (login == null)
				login = new Login();

			GaneshSwing.addI18nListerner(login);

			login.setLocationRelativeTo(null);

			login.setVisible(true);
		}

	}
}
