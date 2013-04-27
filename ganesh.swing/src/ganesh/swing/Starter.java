/*Ganesh Swing Client, developed in 2013*/
package ganesh.swing;

import ganesh.common.i18n.GaneshI18n;
import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.ProgramManager.ProgramDescriptor;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.programs.cadastro.grupo.PrgGrupo;
import ganesh.swing.programs.cadastro.usuario.PrgUsuario;
import ganesh.swing.programs.nota.PrgNota;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.login.Login;
import ganesh.swing.ui.main.GaneshMain;

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
		Hermes.warn("\nGANESH NOTICE:\nCopyright (C) 2013 Rafael Antonio Farinha (rafarinha123@gmail.com)\n\n" +
			"This program is free software: you can redistribute it and/or modify\n" +
			"it under the terms of the GNU General Public License as published by\n" +
			"the Free Software Foundation, either version 3 of the License, or\n" +
			"(at your option) any later version.\n\nThis program is distributed in the hope that it will be useful,\n" +
			"but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
			"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the\n" +
			"GNU General Public License for more details.\n" +
			"You should have received a copy of the GNU General Public License\n" +
			"along with this program. If not, see <http://www.gnu.org/licenses/>.\n");

		Hermes.info("============================ Starting Ganesh Swing");

		try {
			Hermes.info("NimbusLookAndFeel");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			Hermes.warn("No nimbus look and feel");
		}

		GaneshI18n.loadTranslations(Language.PT_BR, Starter.class.getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
		GaneshI18n.loadTranslations(Language.EN_US, Starter.class.getResourceAsStream("i18n/translations/messages.en_US.trd"));

		GaneshSwing.setLanguage(Language.PT_BR);

		GMessages GM = GaneshSwing.getGMessages();

		ProgramManager.registerProgram(new ProgramDescriptor("grupo", PrgGrupo.class, GM.grupo(), Menu.CADASTRO, Icons.GROUP));
		ProgramManager.registerProgram(new ProgramDescriptor("usuario", PrgUsuario.class, GM.usuario(), Menu.CADASTRO, Icons.USER));
		ProgramManager.registerProgram(new ProgramDescriptor("nota", PrgNota.class, GM.nota(), Menu.OPERACAO, Icons.SCRIPT));

		login();
	}

	public static void loadMain() {
		new GaneshMain().start();
	}

	public static void login() {
		GaneshSwing.setSession(null);
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
