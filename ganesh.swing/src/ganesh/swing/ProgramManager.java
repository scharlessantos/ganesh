/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.swing.exceptions.ClientErrorCode;
import ganesh.swing.ui.programs.GaneshProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scharlessantos.hermes.Hermes;

public class ProgramManager {

	private static Map<String, ProgramDescriptor> programs = new HashMap<>();

	public static GaneshProgram newProgram(String name) throws GException {
		synchronized (programs) {
			if (!programs.containsKey(name)) {
				return null;
			}

			ProgramDescriptor program = programs.get(name);

			if (program == null)
				throw new GException(ClientErrorCode.PROGRAM_NOT_REGISTERED, GaneshSwing.getMessages().programaNaoRegistrado());

			Class<? extends GaneshProgram> cls = program.getProgram();

			try {
				if (cls.getConstructor() == null)
					throw new GException(ClientErrorCode.UI, name + " deve possuir um contrutor padrão");
			} catch (NoSuchMethodException | SecurityException e) {
				Hermes.error(e);
				throw new GException(ClientErrorCode.UI, e);
			}

			try {
				return cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				Hermes.error(e);
				throw new GException(ClientErrorCode.UI, e);
			}
		}

	}

	public static List<String> listPrograms() {
		synchronized (programs) {
			return new ArrayList<>(programs.keySet());
		}
	}

	public static GString getTitle(String name) {
		synchronized (programs) {
			ProgramDescriptor program = programs.get(name);

			if (program != null)
				return program.getTitle();
		}

		return null;
	}

	public static void registerProgram(String name, ProgramDescriptor program) {
		synchronized (programs) {
			if (!programs.containsKey(name)) {
				programs.put(name, program);

			} else
				Hermes.warn("Programa " + name + " já registrado");
		}
	}

	public static class ProgramDescriptor {

		private Class<? extends GaneshProgram> program;
		private GString title;
		private GString menu;
		private String icon;

		public ProgramDescriptor(Class<? extends GaneshProgram> program, GString title, GString menu, String icon) {
			super();
			this.program = program;
			this.title = title;
			this.menu = menu;
			this.icon = icon;
		}

		public Class<? extends GaneshProgram> getProgram() {
			return program;
		}

		public GString getTitle() {
			return title;
		}

		public GString getMenu() {
			return menu;
		}

		public String getIcon() {
			return icon;
		}

	}

}
