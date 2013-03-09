/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.programs;

import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

import java.util.HashMap;
import java.util.Map;

import org.scharlessantos.hermes.Hermes;

public class ProgramManager {

	private static Map<String, Class<GaneshProgram>> programs = new HashMap<>();

	public static GaneshProgram newProgram(String name) throws GException {
		synchronized (programs) {
			if (!programs.containsKey(name)) {
				return null;
			}

			Class<GaneshProgram> cls = programs.get(name);

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

	public static enum RequestType {
		SAVE,
		DELETE,
		LIST
	}
}
