/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking;

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

public class PgListPicking extends GaneshListPage {

	public PgListPicking() {
		addColumn("CODIGO", GM.codigo(), 100);
		addColumn("DESCRICAO", GM.descricao(), 150);
		//		addColumn("DATA", GM.data(), 100);

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.CART_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.CART_EDIT));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.CART_DELETE).setConfirmation(GM.desejaRealmenteApagarOsPickingsSelecionados()));

		addButton(new GaneshButton(GM.produtos(), "PRODUTO", Icons.BRICK));
	}

	@Override
	public String getTitle() {
		return M.picking();
	}

	@Override
	public String getIcon() {
		return Icons.CART;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("picking");
		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("pickings"))
			if (ri instanceof XMLData) {
				GaneshData d = new GaneshData();

				XMLData rd = (XMLData)ri;
				for (String key: rd.keySet()) {
					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		getProgram().handleResponse(resp);

		return data;
	}

	@ButtonHandler("NOVO")
	public void salvar() {
		new PgDialogPicking(getProgram()).renderize();

		reloadData();
	}

	@ButtonHandler("EDITAR")
	public void editar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.editar())));
			return;
		}

		PgDialogPicking dialog = new PgDialogPicking(getProgram());
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

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "picking");
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

	@ButtonHandler("PRODUTO")
	public void caminhao(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.visualizar().toLowerCase())));
			return;
		}

		new PgDialogPicking(getProgram()).renderize();

		reloadData();
	}
}
