/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.common.i18n.GString;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.scharlessantos.hermes.Hermes;

public class GaneshButton {

	private GString label;
	private GString tooltip;
	private String action;
	private String icon;

	private GaneshPage page;

	public GaneshButton(GString label, String action, String icon) {
		super();
		this.label = label;
		this.action = action;
		this.icon = icon;
	}

	public GString getLabel() {
		return label;
	}

	public void setLabel(GString label) {
		this.label = label;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public GString getTooltip() {
		return tooltip;
	}

	public void setTooltip(GString tooltip) {
		this.tooltip = tooltip;
	}

	public GaneshPage getPage() {
		return page;
	}

	public void setPage(GaneshPage page) {
		this.page = page;
	}

	public JButton render() {
		JButton button = new JButton(label.toString());
		button.setIcon(Icons.get(icon));

		if (tooltip != null)
			button.setToolTipText(tooltip.toString());

		button.addActionListener(new MyListener());

		return button;
	}

	private class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Hermes.debug("Implementar");
		}

	}
}
