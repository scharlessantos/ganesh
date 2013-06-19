/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cliente;

import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

public class PgListCliente extends GaneshListPage {

	public PgListCliente() {
		addColumn("CODIGO", GM.codigo(), 100);
		addColumn("NOME", GM.nome(), 150);
		addColumn("CONTATO", GM.contato(), 150);
		addColumn("RESPONSAVEL", GM.responsavel(), 175);
		addColumn("ENDERECO", GM.endereco(), 150);

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.BULLET_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.BULLET_WRENCH));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.BULLET_DELETE).setConfirmation(GM.desejaRealmenteApagarOsClientesSelecionados()));
	}

	@Override
	public String getTitle() {
		return M.cliente();
	}

	@Override
	public String getIcon() {
		return Icons.USER_SUIT_BLACK;
	}

}
