/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.request.UpdateRequest;
import ganesh.common.request.UpdateRequest.Acao;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.programs.cadastro.produto.embalagem.PgDialogListEmbalagem;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListProduto extends GaneshListPage {

	public PgListProduto() {
		addColumn("CODIGO", GM.codigo(), 100);
		addColumn("NOME", GM.nome(), 200);
		addColumn("COMPLEMENTO", GM.complemento(), 150);
		addColumn("PESAVEL_TRATADO", GM.pesavel());

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.BRICK_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.BRICK_EDIT));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.BRICK_DELETE).setConfirmation(GM.desejaRealmenteApagarOsProdutosSelecionados()));

		GaneshButton btn = new GaneshButton(GM.embalagens(), "EMBALAGENS", Icons.PACKAGE);
		btn.setTooltip(GM.visualizarAsEmbalagensQuePertencamAoProdutoSelecionado());
		addButton(btn);
	}

	@Override
	public String getTitle() {
		return M.produto();
	}

	@Override
	public String getIcon() {
		return Icons.BRICK;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("produto");
		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("produtos"))
			if (ri instanceof XMLData) {
				GaneshData d = new GaneshData();

				XMLData rd = (XMLData)ri;
				for (String key: rd.keySet()) {
					if (key.equalsIgnoreCase("pesavel"))
						d.setString("PESAVEL_TRATADO", rd.get(key).equalsIgnoreCase("true") ? M.sim() : M.nao());

					d.setString(key.toUpperCase(), rd.get(key));
				}

				data.add(d);
			}

		getProgram().handleResponse(resp);

		return data;
	}

	@ButtonHandler("NOVO")
	public void adicionar() {
		new PgDialogProduto(getProgram()).renderize();

		reloadData();
	}

	@ButtonHandler("EDITAR")
	public void editar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.editar())));
			return;
		}

		PgDialogProduto dialog = new PgDialogProduto(getProgram());
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

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "produto");
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

	@ButtonHandler("EMBALAGENS")
	public void embalagens(GaneshData data) {
		if (data == null || data.count() <= 0 || data.getGaneshDataList(GaneshListPage.SELECTED_ROWS) != null) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.visualizar())));
			return;
		}

		PgDialogListEmbalagem dialog = new PgDialogListEmbalagem(getProgram());
		dialog.setData(data);
		dialog.renderize();

	}
}
