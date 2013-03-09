/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.programs;

import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;
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
					throw new GException(ErrorCode.UNKOWN, name + " deve possuir um contrutor padrão");
			} catch (NoSuchMethodException | SecurityException e) {
				Hermes.error(e);
				throw new GException(ErrorCode.UNKOWN, e);
			}

			try {
				return cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				Hermes.error(e);
				throw new GException(ErrorCode.UNKOWN, e);
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
