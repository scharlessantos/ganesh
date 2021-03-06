/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.i18n.Messages;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGaneshPage {

	protected Messages M = GaneshSwing.getMessages();
	protected GMessages GM = GaneshSwing.getGMessages();

	private List<GaneshButton> buttons = new ArrayList<>();
	private GaneshProgram program;
	protected GaneshData data;

	public abstract String getTitle();

	public abstract String getIcon();

	protected void addButton(GaneshButton button) {
		button.setPage(this);
		buttons.add(button);
	}

	protected List<GaneshButton> listButtons() {
		return new ArrayList<>(buttons);
	}

	public GaneshProgram getProgram() {
		return program;
	}

	public AbstractGaneshPage setProgram(GaneshProgram program) {
		this.program = program;
		return this;
	}

	public abstract void renderize();

	public void setData(GaneshData data) {
		this.data = data;
	}

	public abstract GaneshData getData();

}
