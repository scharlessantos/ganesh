/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto;

import ganesh.common.request.ListRequest;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseData;
import ganesh.common.response.ResponseItem;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListProduto extends GaneshListPage {

	public PgListProduto() {
		addColumn("CODIGO", GM.codigo());
		addColumn("NOME", GM.nome());
		addColumn("COMPLEMENTO", GM.complemento());
		addColumn("PESAVEL", GM.pesavel());

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.BRICK_ADD));
		addButton(new GaneshButton(GM.editar(), "EDIT", Icons.BRICK_EDIT));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.BRICK_DELETE));
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

		for (ResponseItem ri: resp.getList("produtos"))
			if (ri instanceof ResponseData) {
				GaneshData d = new GaneshData();

				ResponseData rd = (ResponseData)ri;
				for (String key: rd.keySet()) {
					if (key.equalsIgnoreCase("pesavel"))
						d.setString(key.toUpperCase(), rd.get(key).equalsIgnoreCase("true") ? M.sim() : M.nao());
					else
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
		new PgDialogProduto(getProgram()).renderize();
	}

}
