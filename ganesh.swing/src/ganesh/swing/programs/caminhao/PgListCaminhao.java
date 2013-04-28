/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.caminhao;

import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.GaneshButton;
import ganesh.swing.ui.GaneshListPage;
import ganesh.swing.ui.images.Images.Icons;

import java.util.List;

public class PgListCaminhao extends GaneshListPage {

	public PgListCaminhao() {
		addColumn("CODIGO", GM.codigo());
		addColumn("EMPRESA", GM.empresa());
		addColumn("PLACA", GM.placa());

		addButton(new GaneshButton(GM.novo(), "novo", Icons.LORRY_ADD));
	}

	@Override
	protected String getIcon() {
		return Icons.LORRY;
	}

	@Override
	protected String getTitle() {
		return M.caminhao();
	}

	protected List<GaneshData> requestData() {
		return null;
	}
}
