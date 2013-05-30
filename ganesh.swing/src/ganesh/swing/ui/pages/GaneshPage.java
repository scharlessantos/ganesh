/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.GMessages;
import ganesh.swing.i18n.Messages;
import ganesh.swing.ui.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public abstract class GaneshPage {

	protected Messages M = GaneshSwing.getMessages();
	protected GMessages GM = GaneshSwing.getGMessages();

	private List<GaneshPage> details = new ArrayList<>();
	private List<GaneshButton> buttons = new ArrayList<>();

	private GaneshProgram program;

	protected void addDetail(GaneshPage detail) {
		details.add(detail);
	}

	protected void addButton(GaneshButton button) {
		button.setPage(this);
		buttons.add(button);
	}

	protected List<GaneshButton> listButtons() {
		return new ArrayList<>(buttons);
	}

	public final JPanel render() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		if (buttons.size() > 0) {
			JToolBar toolbar = new JToolBar();
			toolbar.setFloatable(false);

			for (GaneshButton button: buttons)
				toolbar.add(button.render());

			panel.add(toolbar, BorderLayout.PAGE_START);
		}

		if (details.size() > 0) {
			panel.add(toJPanel());

			JTabbedPane dpanel = new JTabbedPane() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isEnabled() {
					return isDetailEnabled();
				}

			};

			for (GaneshPage detail: this.details)
				if (detail != null)
					dpanel.addTab(detail.getTitle(), Icons.get(detail.getIcon()), detail.render());

			panel.add(dpanel, BorderLayout.SOUTH); //TODO tamanho
		}

		panel.add(toJPanel(), BorderLayout.CENTER);
		return panel;
	}

	public abstract JPanel toJPanel();

	protected abstract String getIcon();

	public abstract String getTitle();

	protected boolean isDetailEnabled() {
		return false;
	}

	public GaneshProgram getProgram() {
		return program;
	}

	public void setProgram(GaneshProgram program) {
		this.program = program;
	}

}
