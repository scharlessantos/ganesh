/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto.embalagem;

import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshDialog;

public class PgDialogListEmbalagem extends GaneshDialog {

	public PgDialogListEmbalagem(GaneshProgram program) {
		super(true, 310, 350, program);

		setPage(new PgListEmbalagem());

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.PACKAGE_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.PACKAGE));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.PACKAGE_DELETE).setConfirmation(GM.desejaRealmenteApagarAsEmbalagensSelecionadas()));
	}

}
