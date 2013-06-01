/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.empresa.motorista;

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

public class PgListMotorista extends GaneshListPage {

	public PgListMotorista() {
		addColumn("CODIGO", GM.codigo(), 90);
		addColumn("NOME", GM.nome(), 200);
		addColumn("DOCUMENTO", GM.documento(), 110);
		addColumn("CONTATO", GM.contato(), 110);
		addColumn("ENDERECO", GM.endereco(), 250);
	}

	@Override
	public String getTitle() {
		return M.motorista();
	}

	@Override
	public String getIcon() {
		return Icons.USER_BROWN;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("empresa", "motorista");
		req.addFilter(new RequestFilter("id_empresa", getProgram().getData().get("ID_EMPRESA"), FilterType.EQUALS));

		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("motoristas"))
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
