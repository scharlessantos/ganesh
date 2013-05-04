/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.exception.ServerErrorCode;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;
import ganesh.programs.ProgramManager;
import ganesh.programs.grupo.PrgGrupo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

public class Ganesh {

	public static Ganesh instance;

	public static Ganesh getInstance() {
		if (instance == null)
			instance = new Ganesh();

		return instance;
	}

	private final int pid;

	private Ganesh() {
		RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
		pid = Integer.parseInt(rt.getName().substring(0, rt.getName().indexOf("@")));
	}

	public int getPid() {
		return pid;
	}

	public void start() throws GException {
		loadProperties();

		GaneshI18n.loadTranslations(Language.PT_BR, Starter.class.getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
		GaneshI18n.loadTranslations(Language.EN_US, Starter.class.getResourceAsStream("i18n/translations/messages.en_US.trd"));

		registerPrograms();

	}

	private void loadProperties() throws GException {
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
			Hermes.error("Cannot load the system configuration");
			Hermes.error(e);

			throw new GException(ServerErrorCode.LOAD_CONFIG);
		}
	}

	private void registerPrograms() {
		ProgramManager.registerProgram("grupo", PrgGrupo.class);
	}

	public static Messages getMessages() {
		return GaneshI18n.genI18nClass(Messages.class);
	}

	public static GMessages getGMessages() {
		return GaneshI18n.genI18nClass(GMessages.class);
	}

	public static int getProperty(String key, int def) {
		String prop = getProperty(key);

		if (prop == null)
			return def;

		try {
			return Integer.parseInt(prop);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	private static String getProperty(String key) {
		return System.getProperty("ganesh." + key);
	}
}
