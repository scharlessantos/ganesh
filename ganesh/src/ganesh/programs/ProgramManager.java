/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.programs.grupo.PrgGrupo;

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
					throw new GException(ErrorCode.UNKNOWN, name + " deve possuir um contrutor padrão");
			} catch (NoSuchMethodException | SecurityException e) {
				Hermes.error(e);
				throw new GException(ErrorCode.UNKNOWN, e);
			}

			try {
				return cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				Hermes.error(e);
				throw new GException(ErrorCode.UNKNOWN, e);
			}
		}

	}

	public static void registerProgram(String name, Class<? extends PrgGrupo> program) {
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
