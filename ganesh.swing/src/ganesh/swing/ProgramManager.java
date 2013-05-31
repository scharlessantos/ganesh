/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.common.i18n.GaneshI18n;
import ganesh.swing.exceptions.ClientErrorCode;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
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

	public static List<ProgramDescriptor> listPrograms() {
		synchronized (programs) {
			return new ArrayList<>(programs.values());
		}
	}

	public static void loadPrograms() {
		File file = new File("bin/ganesh/swing/programs");

		if (file.isDirectory())
			for (File f: file.listFiles())
				loadPrograms(f, "ganesh.swing.programs");

	}

	private static void loadPrograms(File file, String folder) {
		if (file.isFile() && (file.getName().startsWith("Prg") && file.getName().endsWith(".class"))) {
			try {
				Class<?> t = Class.forName(folder + "." + file.getName().replace(".class", ""));

				Class<?> s = t.getSuperclass();

				if (s != null && s.equals(GaneshProgram.class)) {
					GaneshProgram p = (GaneshProgram)t.newInstance();
					registerProgram(p.getProgramDescriptor());
				}

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				Hermes.error(e);
			}
		} else if (file.isDirectory()) {
			for (File f: file.listFiles())
				loadPrograms(f, folder + "." + file.getName());
		}

	}

	private static void registerProgram(ProgramDescriptor program) {
		if (program == null)
			return;

		synchronized (programs) {
			if (!programs.containsKey(program.getName())) {
				programs.put(program.getName(), program);

			} else
				Hermes.warn("Programa " + program.getName() + " já registrado");
		}
	}

	public static GString getTitle(String name) throws GException {
		synchronized (programs) {

			ProgramDescriptor program = programs.get(name);

			if (program == null)
				throw new GException(ClientErrorCode.PROGRAM_NOT_REGISTERED, GaneshSwing.getMessages().programaNaoRegistrado());

			return program.getTitle();
		}
	}

	public static String getIcon(String name) throws GException {
		synchronized (programs) {

			ProgramDescriptor program = programs.get(name);

			if (program == null)
				throw new GException(ClientErrorCode.PROGRAM_NOT_REGISTERED, GaneshSwing.getMessages().programaNaoRegistrado());

			return program.getIcon();
		}
	}

	private static GMessages GM = GaneshI18n.genI18nClass(GMessages.class);

	public enum Menu implements Comparator<Menu> {

		CADASTRO(GM.cadastro(), 0, Icons.APPLICATION_FORM),
		OPERACAO(GM.operacao(), 1, Icons.APPLICATION_VIEW_DETAIL),

		;

		private GString title;
		private int order;
		private String icon;

		private Menu(GString title, int order, String icon) {
			this.title = title;
			this.order = order;
			this.icon = icon;
		}

		public GString getTitle() {
			return title;
		}

		public int getOrder() {
			return order;
		}

		public String getIcon() {
			return icon;
		}

		@Override
		public int compare(Menu me, Menu other) {
			if (me.order == other.order)
				return 0;

			return me.order > other.order ? 1 : -1;
		}

	}

}
