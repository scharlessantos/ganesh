/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GaneshTextInput extends AbstractGaneshControl<JPanel> {

	public GaneshTextInput(String name, GString label) {
		super(name, label);
	}

	private JTextField text;

	@Override
	public JPanel render() {
		text = new JTextField(5);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.insets = new Insets(7, 0, 3, 0);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(new JLabel(label == null ? "" : label.toString()), c);

		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		panel.add(text, c);

		panel.doLayout();

		return panel;
	}

	@Override
	public boolean isResponsible() {
		return true;
	}

	@Override
	public Object get() {
		if (text != null)
			return text.getText();

		return null;
	}
}
