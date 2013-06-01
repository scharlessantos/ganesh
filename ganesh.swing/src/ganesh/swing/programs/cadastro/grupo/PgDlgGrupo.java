/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

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

public class PgDlgGrupo extends GaneshDialog {

	public PgDlgGrupo(GaneshProgram program) {
		super(true, 250, 230, program);

		setLabelFechar(GM.cancelar());
		addButton(new GaneshButton(GM.salvar(), "SALVAR", Icons.DISK));

		setPage(new GaneshControlPage() {

			{
				addControl(new GaneshTextInput("CODIGO", GM.codigo()));
				addControl(new GaneshTextInput("DESCRICAO", GM.nome()));
			}

			@Override
			public String getTitle() {
				return M.grupo();
			}

			@Override
			public String getIcon() {
				return Icons.GROUP;
			}
		});

	}

	@ButtonHandler("SALVAR")
	public void onSalvar(GaneshData data) {
		UpdateRequest req = new UpdateRequest(Acao.SALVAR, "grupo");
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
