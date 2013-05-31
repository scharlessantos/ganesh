/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.exceptions.GException;
import ganesh.exception.ServerErrorCode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.scharlessantos.hermes.Hermes;

public class ProgramManager {

	private static Map<String, Class<? extends GaneshProgram>> programs = new HashMap<>();

	public static GaneshProgram newProgram(String name) throws GException {
		synchronized (programs) {
			if (!programs.containsKey(name)) {
				return null;
			}

			Class<? extends GaneshProgram> cls = programs.get(name);

			try {
				if (cls.getConstructor() == null)
					throw new GException(ServerErrorCode.UNKNOWN, name + " deve possuir um contrutor padrão");
			} catch (NoSuchMethodException | SecurityException e) {
				Hermes.error(e);
				throw new GException(ServerErrorCode.UNKNOWN, e);
			}

			try {
				return cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				Hermes.error(e);
				throw new GException(ServerErrorCode.UNKNOWN, e);
			}
		}

	}

	public static void loadPrograms() {
		File file = new File("bin/ganesh/programs");

		if (file.isDirectory())
			for (File f: file.listFiles())
				if (f.isFile() && (f.getName().startsWith("Prg") && f.getName().endsWith(".class"))) {
					try {
						Class<?> t = Class.forName("ganesh.programs." + f.getName().replace(".class", ""));

						Class<?> s = t.getSuperclass();

						if (s != null && s.equals(GaneshProgram.class)) {
							GaneshProgram p = (GaneshProgram)t.newInstance();
							registerProgram(p.getName(), p.getClass());
						}

					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
						Hermes.error(e);
					}
				}
	}

	protected static void registerProgram(String name, Class<? extends GaneshProgram> program) {
		synchronized (programs) {
			if (!programs.containsKey(name))
				programs.put(name, program);
			else
				Hermes.warn("Programa " + name + " já registrado");
		}
	}

	public static enum RequestType {
		SAVE,
		DELETE,
		LIST
	}
}
