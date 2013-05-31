/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import org.scharlessantos.hermes.Hermes;

public abstract class GaneshPage extends AbstractGaneshPage {

	private List<GaneshPage> details = new ArrayList<>();

	protected void addDetail(GaneshPage detail) {
		details.add(detail);
	}

	public final JPanel render() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		List<GaneshButton> buttons = listButtons();

		if (buttons.size() > 0) {
			JToolBar toolbar = new JToolBar();
			toolbar.setFloatable(false);

			for (GaneshButton button: buttons)
				toolbar.add(button.render());

			panel.add(toolbar, BorderLayout.PAGE_START);
		}

		if (isDetailEnabled())
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

	protected abstract JPanel toJPanel();

	protected boolean isDetailEnabled() {
		return false;
	}

	@Override
	public final void renderize() {
		Hermes.error(String.format("renderize() não é tratado em GaneshPage(%s)", getClass().getName()));
	}

}
