/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.swing.ui.GaneshListPage;
import ganesh.swing.ui.images.Images.Icons;

public class PgListUsuarioDetail extends GaneshListPage {

	public PgListUsuarioDetail() {
		addColumn("CODIGO", GM.codigo(), 2);
		addColumn("NOME", GM.nome(), 4);
		addColumn("USERNAME", GM.username(), 3);
	}

	@Override
	protected String getIcon() {
		return Icons.USER;
	}

	@Override
	protected String getTitle() {
		return M.usuario();
	}

}