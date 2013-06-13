/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GaneshComboBox<E> extends AbstractGaneshControl<JPanel> {

	public GaneshComboBox(String name, GString label) {
		super(name, label);
	}

	private List<E> myList = new ArrayList<>();

	@Override
	public JPanel render() {
		List<E> e = getData();

		combo.removeAllItems();

		if (e != null)
			for (E i: e)
				combo.addItem(i.toString());

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
		panel.add(combo, c);

		panel.doLayout();

		return panel;
	}

	protected abstract List<E> getData();

	private JComboBox<String> combo = new JComboBox<>();

	@Override
	public Object get() {
		if (combo.getSelectedIndex() > 0)
			return myList.get(combo.getSelectedIndex());

		return null;
	}

	@Override
	public boolean isResponsive() {
		return false;
	}

}
