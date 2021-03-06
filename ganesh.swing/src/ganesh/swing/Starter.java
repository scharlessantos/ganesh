/*Ganesh Swing Client, developed in 2013*/
package ganesh.swing;

import ganesh.common.i18n.GaneshI18n;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.i18n.Messages;
import ganesh.swing.ui.login.Login;
import ganesh.swing.ui.main.GaneshMain;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader(new File("config.ini")));

			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#") || line.startsWith("//") || line.startsWith("--") || line.trim().isEmpty())
					continue;

				String[] prop = line.split("=");

				if (prop == null || prop.length != 2) {
					Hermes.warn("Ignoring malformed line specification: " + line);
					continue;
				}

				System.setProperty(prop[0], prop[1]);
			}

			reader.close();

		} catch (IOException e) {
			Hermes.fatal("Nao foi possivel carregar as propriedades do client");
			Hermes.fatal(e);
			System.exit(45);
		}

		try {
			Hermes.info("NimbusLookAndFeel");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			Hermes.warn("No nimbus look and feel");
		}

		GaneshI18n.loadTranslations(Language.PT_BR, Starter.class.getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
		GaneshI18n.loadTranslations(Language.EN_US, Starter.class.getResourceAsStream("i18n/translations/messages.en_US.trd"));

		if (new File(".svn").isDirectory()) {
			//Se estiver rodando no eclipse, gera o arquivo trd com as traduções que faltam

			Language[] lang = { Language.PT_BR, Language.EN_US };

			for (Language l: lang) {
				Map<String, String> tradutor = new HashMap<>();
				GaneshI18n.setLanguage(l);

				List<Method> methods = new ArrayList<>();

				methods.addAll(Arrays.asList(Messages.class.getMethods()));
				methods.addAll(Arrays.asList(GMessages.class.getMethods()));

				for (Method m: methods) {
					String key = m.getName();

					key += "(";

					String param = null;

					for (Class<?> p: m.getParameterTypes())
						param = param == null ? p.getSimpleName() : param + ", " + p.getSimpleName();

					if (param != null)
						key += param;

					key += ")";

					if (!tradutor.containsKey(key)) {
						String traducao = GaneshI18n.translate(key);

						if (traducao.equals(key))
							traducao = null;

						tradutor.put(key, traducao);
					}

				}

				List<String> keys = new ArrayList<>(tradutor.keySet());

				Collections.sort(keys);

				try {
					FileWriter fw = new FileWriter(new File("src/ganesh/swing/i18n/translations/messages." + l.getAcronym() + ".trd"));

					for (String key: keys) {
						String traducao = tradutor.get(key);

						if (traducao == null)
							fw.append("#");

						fw.append(key);
						fw.append("=");

						if (traducao != null)
							fw.append(traducao);

						fw.append("\n");
					}

					fw.close();

				} catch (IOException e) {
					Hermes.error(e);
				}

			}

		}

		GaneshSwing.setLanguage(Language.PT_BR);

		ProgramManager.loadPrograms();

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
