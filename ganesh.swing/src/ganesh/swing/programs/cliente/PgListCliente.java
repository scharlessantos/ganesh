/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cliente;

import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

public class PgListCliente extends GaneshListPage {

	@Override
	public String getTitle() {
		return M.cliente();
	}

	@Override
	public String getIcon() {
		return Icons.USER_SUIT_BLACK;
	}

}
