/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.empresa.caminhao;

import ganesh.common.exceptions.GException;
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
import ganesh.swing.ui.controls.GaneshTextInput;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshControlPage;
import ganesh.swing.ui.pages.GaneshDialog;

public class PgDialogCaminhao extends GaneshDialog {

	public PgDialogCaminhao(GaneshProgram program) {
		super(true, 250, 300, program);

		setPage(new GaneshControlPage() {

			{

				addControl(new GaneshTextInput("CODIGO", GM.codigo()));
				addControl(new GaneshTextInput("PLACA", GM.placa()));

			}

			@Override
			public String getTitle() {
				return M.caminhao();
			}

			@Override
			public String getIcon() {
				return Icons.LORRY;
			}
		});

		setLabelFechar(GM.cancelar());

		addButton(new GaneshButton(GM.salvar(), "SALVAR", Icons.DISK));
	}

	@ButtonHandler("SALVAR")
	public void onSalvar(GaneshData data) {
		UpdateRequest req = new UpdateRequest(Acao.SALVAR, "empresa", "caminhao");
		req.setSession(GaneshSwing.getSession());

		data.setObject("ID_EMPRESA", getProgram().getData().get("ID_EMPRESA"));
		req.addItem(data);

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
