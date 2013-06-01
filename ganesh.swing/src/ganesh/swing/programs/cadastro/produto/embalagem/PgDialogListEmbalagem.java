/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.produto.embalagem;

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

public class PgDialogListEmbalagem extends GaneshDialog {

	public PgDialogListEmbalagem(GaneshProgram program) {
		super(true, 310, 350, program);

		setPage(new PgListEmbalagem());

		addButton(new GaneshButton(GM.novo(), "NOVO", Icons.PACKAGE_ADD));
		addButton(new GaneshButton(GM.editar(), "EDITAR", Icons.PACKAGE));
		addButton(new GaneshButton(GM.excluir(), "DELETE", Icons.PACKAGE_DELETE).setConfirmation(GM.desejaRealmenteApagarAsEmbalagensSelecionadas()));
	}

	@ButtonHandler("NOVO")
	public void adicionar() {
		new PgDialogEmbalagem(getProgram()).renderize();

		((GaneshListPage)page).reloadData();
	}

	@ButtonHandler("EDITAR")
	public void editar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.editar())));
			return;
		}

		PgDialogEmbalagem dialog = new PgDialogEmbalagem(getProgram());
		dialog.setData(data);

		dialog.renderize();
		((GaneshListPage)page).reloadData();
	}

	@ButtonHandler("DELETE")
	public void deletar(GaneshData data) {
		if (data == null || data.count() <= 0) {
			MessageHandler.show(new WarningMessage(M.selecioneOItemA_(M.apagar())));
			return;
		}

		UpdateRequest req = new UpdateRequest(Acao.DELETAR, "produto", "embalagem");
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
