/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking.produto;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.exceptions.GException;
import ganesh.common.request.ListRequest;
import ganesh.common.request.UpdateRequest;
import ganesh.common.request.UpdateRequest.Acao;
import ganesh.common.response.Message.ErrorMessage;
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

public class PgDialogAddProduto extends GaneshDialog {

	public PgDialogAddProduto(GaneshProgram program) {
		super(true, 500, 550, program);

		setPage(new GaneshListPage() {

			{
				addColumn("PRODUTO", GM.produto(), 220);
				addColumn("EMBALAGEM", GM.embalagem(), 120);
				addColumn("QTD", GM.qtde());

				setMulti(true);
			}

			@Override
			public String getTitle() {
				return M.adicionar_(M.produto());
			}

			@Override
			public String getIcon() {
				return Icons.BRICK_ADD;
			}

			@Override
			protected List<GaneshData> loadTableData() {
				List<GaneshData> data = new ArrayList<>();

				ListRequest req = new ListRequest("picking", "produtos/add");
				req.setSession(GaneshSwing.getSession());

				Response resp = req.doRequest();

				for (XMLItem ri: resp.getList("embalagens"))
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

		addButton(new GaneshButton(GM.adicionar(), "ADICIONAR", Icons.BRICK_LINK));
	}

	@ButtonHandler("ADICIONAR")
	public void adicionar(GaneshData data) {
		UpdateRequest req = new UpdateRequest(Acao.SALVAR, "picking", "produtos");
		req.setSession(GaneshSwing.getSession());

		String picking = getProgram().getData().getString("ID_PICKING");

		if (data.getGaneshDataList(GaneshListPage.SELECTED_ROWS) != null) {
			for (GaneshData d: data.getGaneshDataList(GaneshListPage.SELECTED_ROWS)) {
				d.setObject("ID_PICKING", picking);
				d.setInteger("QTD", 1);
				req.addItem(d);
			}

		} else {
			data.setObject("ID_PICKING", picking);
			data.setInteger("QTD", 1);

			req.addItem(data);
		}

		Response resp = req.doRequest();

		getProgram().handleResponse(resp);

		if (resp.getResponseValue() == null || resp.getResponseValue().intValue() == Response.OK)
			try {
				close();
			} catch (GException e) {
				MessageHandler.show(new ErrorMessage(e.getMessage()));
			}
	}
}
