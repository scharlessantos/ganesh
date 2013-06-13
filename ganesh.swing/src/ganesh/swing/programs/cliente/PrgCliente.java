/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cliente;

import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.programs.ProgramDescriptor;
import ganesh.swing.ui.images.Images.Icons;

public class PrgCliente extends GaneshProgram {

	@Override
	public ProgramDescriptor getProgramDescriptor() {
		return new ProgramDescriptor("cliente", getClass(), GM.cliente(), Menu.CADASTRO, Icons.USER_SUIT_BLACK);
	}

}
