/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.nota;

import ganesh.common.i18n.GString;
import ganesh.common.request.ListRequest;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseData;
import ganesh.common.response.ResponseItem;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListProdutoNota extends GaneshListPage {

	public PgListProdutoNota() {
		addColumn(new Column("CODIGO", GM.codigo(), 3));
		addColumn(new Column("NOME", new GString("Nome"), 3));
		addColumn(new Column("QTD", new GString("QTD"), 3));

		addButton(new GaneshButton(new GString("Adicionar"), "ACT_NOVO", Icons.PACKAGE_ADD));
		addButton(new GaneshButton(new GString("Remover"), "ACT_EXCLUIR", Icons.PACKAGE_DELETE));
	}

	@Override
	public String getIcon() {
		return Icons.PACKAGE;
	}

	@Override
	public String getTitle() {
		return "Produto";
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		Response resp = new ListRequest("nota", "produto").doRequest();

		for (ResponseItem ri: resp.getList("produtos"))
			if (ri instanceof ResponseData) {
				GaneshData d = new GaneshData();

				ResponseData rd = (ResponseData)ri;
				for (String key: rd.keySet()) {
					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		return data;
	}

}
