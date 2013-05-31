/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgGrupo extends GaneshProgram {

	public PrgGrupo() {
		setPage(new PgListGrupo());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("grupo", PrgGrupo.class, GM.grupo(), Menu.CADASTRO, Icons.GROUP);
	}
}
