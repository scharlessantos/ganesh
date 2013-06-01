/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.empresa.caminhao;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.request.RequestFilter;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListCaminhao extends GaneshListPage {

	public PgListCaminhao() {
		addColumn("CODIGO", GM.codigo(), 140);
		addColumn("PLACA", GM.placa(), 90);
	}

	@Override
	public String getTitle() {
		return M.caminhao();
	}

	@Override
	public String getIcon() {
		return Icons.LORRY;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("empresa", "caminhao");
		req.addFilter(new RequestFilter("id_empresa", getProgram().getData().get("ID_EMPRESA"), FilterType.EQUALS));

		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("caminhoes"))
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

}
