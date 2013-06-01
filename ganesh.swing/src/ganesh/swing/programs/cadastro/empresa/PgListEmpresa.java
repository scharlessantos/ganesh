/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.empresa;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.request.ListRequest;
import ganesh.common.request.UpdateRequest;
import ganesh.common.request.UpdateRequest.Acao;
import ganesh.common.response.Message.WarningMessage;
import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.programs.cadastro.empresa.caminhao.PgDialogListCaminhao;
import ganesh.swing.programs.cadastro.empresa.motorista.PgDialogListMotorista;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshListPage;

import java.util.ArrayList;
import java.util.List;

public class PgListEmpresa extends GaneshListPage {

	public PgListEmpresa() {
		addColumn("CODIGO", GM.codigo());
		addColumn("NOME", GM.nome(), 150);
		addColumn("CNPJ", GM.cnpj(), 100);

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.BUILDING_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.BUILDING_EDIT));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.BUILDING_DELETE).setConfirmation(GM.desejaRealmenteApagarAsEmpresasSelecionadas()));

		addButton(new GaneshButton(GM.caminhoes(), "CAMINHAO", Icons.LORRY));
		addButton(new GaneshButton(GM.motorista(), "MOTORISTA", Icons.LORRY_GROUP));

	}

	@Override
	public String getTitle() {
		return M.empresa();
	}

	@Override
	public String getIcon() {
		return Icons.BUILDING;
	}

	@Override
	protected List<GaneshData> loadTableData() {
		List<GaneshData> data = new ArrayList<>();

		ListRequest req = new ListRequest("empresa");
		req.setSession(GaneshSwing.getSession());

		Response resp = req.doRequest();

		for (XMLItem ri: resp.getList("empresas"))
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
	public void adicionar() {
		new PgDialogEmpresa(getProgram()).renderize();

		reloadData();
	}

	@ButtonHandler("EDITAR")
	public void editar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.editar())));
			return;
		}

		PgDialogEmpresa dialog = new PgDialogEmpresa(getProgram());
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

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "empresa");
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

	@ButtonHandler("CAMINHAO")
	public void caminhao(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.visualizar().toLowerCase())));
			return;
		}

		new PgDialogListCaminhao(getProgram()).renderize();

		reloadData();
	}

	@ButtonHandler("MOTORISTA")
	public void motorista(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.visualizar().toLowerCase())));
			return;

		}

		new PgDialogListMotorista(getProgram()).renderize();

		reloadData();

	}
}
