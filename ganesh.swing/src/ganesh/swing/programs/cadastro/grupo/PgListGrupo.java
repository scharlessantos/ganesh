/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.common.request.ListRequest;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseData;
import ganesh.common.response.ResponseItem;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.GaneshButton;
import ganesh.swing.ui.GaneshListPage;
import ganesh.swing.ui.images.Images.Icons;

import java.util.ArrayList;
import java.util.List;

public class PgListGrupo extends GaneshListPage {

	public PgListGrupo() {
		addColumn("CODIGO", GM.codigo());
		addColumn("DESCRICAO", GM.nome());

		addButton(new GaneshButton(GM.novo(), "", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "", Icons.GROUP_DELETE));

		addDetail(new PgListUsuarioDetail());
	}

	@Override
	protected String getIcon() {
		return Icons.GROUP;
	}

	@Override
	protected String getTitle() {
		return M.grupo();
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		Response resp = new ListRequest("grupo").doRequest();

		for (ResponseItem ri: resp.getList("grupos"))
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
