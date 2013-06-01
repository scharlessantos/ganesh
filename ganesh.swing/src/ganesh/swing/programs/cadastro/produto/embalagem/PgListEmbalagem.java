/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto.embalagem;

import ganesh.common.request.ListRequest;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListEmbalagem extends GaneshListPage {

	public PgListEmbalagem() {
		addColumn("DESCRICAO", GM.descricao(), 120);
		addColumn("QTD", GM.qtde());
	}

	@Override
	public String getTitle() {
		return M.embalagem();
	}

	@Override
	public String getIcon() {
		return Icons.PACKAGE;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("produto", "embalagem");

		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		//		for (XMLItem ri: resp.getList("embalagens"))
		//			if (ri instanceof XMLData) {
		//				GaneshData d = new GaneshData();
		//
		//				XMLData rd = (XMLData)ri;
		//				for (String key: rd.keySet()) {
		//					d.setString(key.toUpperCase(), rd.get(key));
		//				}
		//
		//				data.add(d);
		//			}

		getProgram().handleResponse(resp);

		return data;
	}

}
