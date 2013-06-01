/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking;

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

public class PgDialogPicking extends GaneshDialog {

	public PgDialogPicking(GaneshProgram program) {
		super(true, 250, 250, program);

		setPage(new GaneshControlPage() {

			{
				addControl(new GaneshTextInput("CODIGO", GM.codigo()));
				addControl(new GaneshTextInput("DESCRICAO", GM.descricao()));
			}

			@Override
			public String getTitle() {
				return M.picking();
			}

			@Override
			public String getIcon() {
				return Icons.CART;
			}
		});

		setLabelFechar(GM.cancelar());

		addButton(new GaneshButton(GM.salvar(), "SALVAR", Icons.DISK));
	}

	@ButtonHandler("SALVAR")
	public void onSalvar(GaneshData data) {
		UpdateRequest req = new UpdateRequest(Acao.SALVAR, "picking");
		req.setSession(GaneshSwing.getSession());
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
