/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.swing.ui.GaneshButton;
import ganesh.swing.ui.GaneshListPage;
import ganesh.swing.ui.images.Images.Icons;

public class PgListGrupo extends GaneshListPage {

	public PgListGrupo() {
		addColumn("", GM.codigo());
		addColumn("", GM.nome());

		addButton(new GaneshButton(GM.novo(), "", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "", Icons.GROUP_DELETE));
	}

	@Override
	protected String getIcon() {
		return Icons.GROUP;
	}

	@Override
	protected String getTitle() {
		return M.grupo();
	}

}
