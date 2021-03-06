/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking.produto;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.request.RequestFilter;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.request.UpdateRequest;
import ganesh.common.request.UpdateRequest.Acao;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshDialog;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgDialogListProduto extends GaneshDialog {

	public PgDialogListProduto(GaneshProgram program) {
		super(true, 550, 600, program);

		setPage(new GaneshListPage() {

			{
				addColumn("PRODUTO", GM.produto(), 220);
				addColumn("EMBALAGEM", GM.embalagem(), 175);
				addColumn("QTD", GM.qtde());

			}

			@Override
			public String getTitle() {
				return M.produtos();
			}

			@Override
			public String getIcon() {
				return Icons.BRICKS;
			}

			@Override
			protected List<GaneshData> loadTableData() {
				List<GaneshData> data = new ArrayList<>();

				ListRequest req = new ListRequest("picking", "produtos");
				req.setSession(GaneshSwing.getSession());
				req.addFilter(new RequestFilter("id_picking", getProgram().getData().get("ID_PICKING"), FilterType.EQUALS));

				Response resp = req.doRequest();

				for (XMLItem ri: resp.getList("produtos"))
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
		});

		addButton(new GaneshButton(GM.adicionar(), "ADICIONAR", Icons.BRICK_ADD));
		addButton(new GaneshButton(GM.alterarQtde(), "QUANTIDADE", Icons.BRICKS));
		addButton(new GaneshButton(GM.remover(), "REMOVER", Icons.BRICK_DELETE).setConfirmation(GM.desejaRealmenteApagarOsProdutosSelecionados()));
	}

	@ButtonHandler("ADICIONAR")
	public void adicionar() {
		new PgDialogAddProduto(getProgram()).renderize();

		((GaneshListPage)page).reloadData();
	}

	@ButtonHandler("QUANTIDADE")
	public void quantidade(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.alterarQuantidade().toLowerCase())));
			return;
		}

		PgDialogEditQtd dialog = new PgDialogEditQtd(getProgram());
		dialog.setData(data);
		dialog.renderize();

		((GaneshListPage)page).reloadData();
	}

	@ButtonHandler("REMOVER")
	public void remover(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.apagar())));
			return;
		}

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "picking", "produtos");
		req.setSession(GaneshSwing.getSession());

		if (data.getGaneshDataList(GaneshListPage.SELECTED_ROWS) != null) {
			for (GaneshData d: data.getGaneshDataList(GaneshListPage.SELECTED_ROWS))
				req.addItem(d);

		} else {
			req.addItem(data);
		}

		Response resp = req.doRequest();

		getProgram().handleResponse(resp);

		((GaneshListPage)page).reloadData();
	}

}
