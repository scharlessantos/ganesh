/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseData;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListGrupo extends GaneshListPage {

	public PgListGrupo() {
		addColumn("CODIGO", GM.codigo());
		addColumn("DESCRICAO", GM.nome());

		addButton(new GaneshButton(GM.novo(), "GRP_NOVO", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "GRP_EDIT", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "GRP_DELETE", Icons.GROUP_DELETE));

		//addDetail(new PgListUsuarioDetail());
	}

	@Override
	public String getIcon() {
		return Icons.GROUP;
	}

	@Override
	public String getTitle() {
		return M.grupo();
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("grupo");
		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("grupos"))
			if (ri instanceof ResponseData) {
				GaneshData d = new GaneshData();

				ResponseData rd = (ResponseData)ri;
				for (String key: rd.keySet()) {
					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		if (resp.getMessage() != null)
			MessageHandler.show(resp.getMessage());

		return data;
	}

	@ButtonHandler("GRP_NOVO")
	public void adicionar() {
		new PgDlgGrupo(getProgram()).renderize();
	}

	@ButtonHandler("GRP_DELETE")
	public void delete(GaneshData selected) {
		if (selected == null)
			MessageHandler.show(new WarningMessage(M.selecioneOItemADeletar()).setTitle(M.atencao()));
	}
}
