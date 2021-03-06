/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.request.UpdateRequest;
import ganesh.common.request.UpdateRequest.Acao;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
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
		addColumn("CODIGO", GM.codigo(), 80);
		addColumn("DESCRICAO", GM.nome(), 180);

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.GROUP_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.GROUP_EDIT));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.GROUP_DELETE).setConfirmation(GM.desejaRealmenteApagarOsGruposSelecionados()));
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
			if (ri instanceof XMLData) {
				GaneshData d = new GaneshData();

				XMLData rd = (XMLData)ri;
				for (String key: rd.keySet()) {
					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		if (resp.getMessage() != null)
			MessageHandler.show(resp.getMessage());

		return data;
	}

	@ButtonHandler("NOVO")
	public void adicionar() {
		new PgDlgGrupo(getProgram()).renderize();

		reloadData();
	}

	@ButtonHandler("EDITAR")
	public void editar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.editar())));
			return;
		}

		PgDlgGrupo dialog = new PgDlgGrupo(getProgram());
		dialog.setData(data);

		dialog.renderize();

		reloadData();
	}

	@ButtonHandler("DELETE")
	public void deletar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.apagar())));
			return;
		}

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "grupo");
		req.setSession(GaneshSwing.getSession());

		if (data.getGaneshDataList(GaneshListPage.SELECTED_ROWS) != null) {
			for (GaneshData d: data.getGaneshDataList(GaneshListPage.SELECTED_ROWS))
				req.addItem(d);

		} else {
			req.addItem(data);
		}

		Response resp = req.doRequest();

		getProgram().handleResponse(resp);

		reloadData();
	}
}
