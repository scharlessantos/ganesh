/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.caminhao;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgCaminhao extends GaneshProgram {

	public PrgCaminhao() {
		setPage(new PgListCaminhao());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("caminhao", PrgCaminhao.class, GM.caminhao(), Menu.OPERACAO, Icons.LORRY);
	}
}
