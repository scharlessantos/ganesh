/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.programs.ProgramManager;
import ganesh.programs.grupo.PrgGrupo;

public class Ganesh {

	public static Ganesh instance;

	public static Ganesh getInstance() {
		if (instance == null)
			instance = new Ganesh();

		return instance;
	}

	private Ganesh() {

	}

	public void start() {
		registerPrograms();
	}

	private void registerPrograms() {
		ProgramManager.registerProgram("grupo", PrgGrupo.class);
	}

}
