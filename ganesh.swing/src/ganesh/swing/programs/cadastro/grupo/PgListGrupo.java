/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.common.request.ListRequest;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseData;
import ganesh.common.response.ResponseItem;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.ButtonHandler;
import ganesh.swing.ui.GaneshButton;
import ganesh.swing.ui.GaneshListPage;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.images.Images.Icons;

import java.util.ArrayList;
import java.util.List;

public class PgListGrupo extends GaneshListPage {

	public PgListGrupo() {
		addColumn("CODIGO", GM.codigo());
		addColumn("DESCRICAO", GM.nome());

		addButton(new GaneshButton(GM.novo(), "GRP_NOVO", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "GRP_EDIT", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "GRP_DELETE", Icons.GROUP_DELETE));

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

	@ButtonHandler("GRP_DELETE")
	public void delete(GaneshData selected) {
		if (selected == null)
			MessageHandler.show(new WarningMessage(M.selecioneOItemADeletar()).setTitle(M.atencao()));
	}
}
