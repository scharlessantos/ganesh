/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GaneshTextInput extends GaneshControl<JPanel> {

	public GaneshTextInput(GString label) {
		super(label);
	}

	@Override
	public JPanel render() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel(label.toString()), BorderLayout.WEST);
		panel.add(new JTextField(5), BorderLayout.CENTER);
		return panel;
	}
}
