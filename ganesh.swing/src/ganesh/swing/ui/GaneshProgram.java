/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.i18n.Messages;
import ganesh.swing.programs.GaneshData;

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
		return null;
	}
}
