/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.nota;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgNota extends GaneshProgram {

	public PrgNota() {
		setPage(new PgListNota());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("nota", PrgNota.class, GM.nota(), Menu.OPERACAO, Icons.SCRIPT);
	}
}
