/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.nota;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.i18n.GString;
import ganesh.common.request.ListRequest;
import ganesh.common.response.Response;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListNota extends GaneshListPage {

	public PgListNota() {
		addColumn(new Column("CODIGO", GM.codigo(), 3));
		addColumn(new Column("CLIENTE", new GString("Cliente"), 3));

		addButton(new GaneshButton(GM.novo(), "ACT_NOVO", Icons.SCRIPT_ADD));
		addButton(new GaneshButton(GM.excluir(), "ACT_EXCLUIR", Icons.SCRIPT_DELETE));
		addButton(new GaneshButton(new GString("Emitir"), "ACT_EXCLUIR", Icons.SCRIPT_GEAR));

		//addDetail(new PgListProdutoNota());
	}

	@Override
	public String getIcon() {
		return Icons.SCRIPT;
	}

	@Override
	public String getTitle() {
		return M.nota();
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		Response resp = new ListRequest("nota").doRequest();

		for (XMLItem ri: resp.getList("notas"))
			if (ri instanceof XMLData) {
				GaneshData d = new GaneshData();

				XMLData rd = (XMLData)ri;
				for (String key: rd.keySet()) {
					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		return data;
	}
}
