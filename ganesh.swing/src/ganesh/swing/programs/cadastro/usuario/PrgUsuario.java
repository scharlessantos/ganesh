/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.usuario;

import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;

public class PrgUsuario extends GaneshProgram {

	public PrgUsuario() {
		setPage(new PgListUsuario());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return null;
		//		return new ProgramDescriptor("usuario", PrgUsuario.class, GM.usuario(), Menu.CADASTRO, Icons.USER);
	}

}
