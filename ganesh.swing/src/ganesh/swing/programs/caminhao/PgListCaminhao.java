/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.caminhao;

import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.List;

public class PgListCaminhao extends GaneshListPage {

	public PgListCaminhao() {
		addColumn("CODIGO", GM.codigo());
		addColumn("EMPRESA", GM.empresa());
		addColumn("PLACA", GM.placa());

		addButton(new GaneshButton(GM.novo(), "novo", Icons.LORRY_ADD));
	}

	@Override
	public final String getIcon() {
		return Icons.LORRY;
	}

	@Override
	public String getTitle() {
		return M.caminhao();
	}

	protected List<GaneshData> requestData() {
		return null;
	}
}
