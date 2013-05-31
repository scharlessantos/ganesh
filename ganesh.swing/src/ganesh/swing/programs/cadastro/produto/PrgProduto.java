/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgProduto extends GaneshProgram {

	public PrgProduto() {
		setPage(new PgListProduto());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("produto", getClass(), GM.produto(), Menu.CADASTRO, Icons.BRICK);
	}

}
