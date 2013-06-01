/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgPicking extends GaneshProgram {

	public PrgPicking() {
		setPage(new PgListPicking());
	}

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("picking", getClass(), GM.picking(), Menu.OPERACAO, Icons.CART);
	}

}
