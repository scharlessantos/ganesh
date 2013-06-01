/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs;

import ganesh.common.response.Response;
import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.i18n.Messages;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.main.GaneshMainFrame;
import ganesh.swing.ui.pages.GaneshPage;

import javax.swing.JPanel;

public abstract class GaneshProgram {

	protected Messages M = GaneshSwing.getMessages();
	protected GMessages GM = GaneshSwing.getGMessages();

	private GaneshPage page;

	public GaneshPage getPage() {
		return page;
	}

	protected void setPage(GaneshPage page) {
		this.page = page;
		page.setProgram(this);
	}

	public JPanel render() {
		if (page == null)
			return null;

		return page.render();
	}

	public GaneshData getData() {
		if (page == null)
			return null;

		return page.getData();

	}

	public abstract ProgramDescriptor getProgramDescriptor();

	public void handleResponse(Response resp) {
		if (resp.getResponseValue() != null && (resp.getResponseValue().intValue() == Response.SESSAO_INVALIDA || resp.getResponseValue().intValue() == Response.ACESSO_NEGADO)) {
			MessageHandler.show(resp.getMessage());

			GaneshMainFrame.getInstance().logout(true);

			Thread.currentThread().interrupt();

		} else if (resp.getMessage() != null)
			MessageHandler.show(resp.getMessage());
	}
}
