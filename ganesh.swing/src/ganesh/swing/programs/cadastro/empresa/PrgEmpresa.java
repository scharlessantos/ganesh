/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.empresa;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgEmpresa extends GaneshProgram {

	public PrgEmpresa() {
		setPage(new PgListEmpresa());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("empresa", getClass(), GM.empresa(), Menu.CADASTRO, Icons.BUILDING);

	}

}
