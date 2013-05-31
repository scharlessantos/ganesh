/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.usuario;

import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

public class PgListUsuario extends GaneshListPage {

	public PgListUsuario() {
		addColumn("CODIGO", GM.codigo());
		addColumn("NOME", GM.nome());
		addColumn("USERNAME", GM.username());
		addColumn("DOCTO", GM.documento());
		addColumn("CONTATO", GM.contato());
		addColumn("ENDERECO", GM.endereco());

		addButton(new GaneshButton(GM.novo(), "", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "", Icons.GROUP_DELETE));
	}

	@Override
	public String getIcon() {
		return Icons.USER;
	}

	@Override
	public String getTitle() {
		return M.usuario();
	}

}
