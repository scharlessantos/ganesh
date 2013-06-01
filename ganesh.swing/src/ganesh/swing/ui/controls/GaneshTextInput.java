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

	private boolean readOnly = false;

	public GaneshTextInput(String name, GString label) {
		super(name, label);
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public GaneshTextInput setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		return this;
	}

	private JTextField text = new JTextField();

	@Override
	public JPanel render() {

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
		text.setEditable(!readOnly);
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
		return text.getText();
	}

	@Override
	public void set(Object set) {
		if (set != null) {
			text.setText(set.toString());

		} else
			super.set(set);
	}
}
