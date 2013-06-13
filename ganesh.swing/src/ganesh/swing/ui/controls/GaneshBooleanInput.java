/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;

import javax.swing.JCheckBox;

public class GaneshBooleanInput extends AbstractGaneshControl<JCheckBox> {

	public GaneshBooleanInput(String name, GString label) {
		super(name, label);
	}

	private JCheckBox check = new JCheckBox();

	@Override
	public JCheckBox render() {
		check.setText(label == null ? "" : label.toString());
		return check;
	}

	@Override
	public boolean isResponsive() {
		return true;
	}

	@Override
	public Object get() {
		return check.isSelected();
	}

	@Override
	public void set(Object set) {
		if (set != null)
			try {
				boolean b = Boolean.parseBoolean(set.toString());
				check.setSelected(b);
				return;
			} catch (Exception ignore) {}

		super.set(set);
	}
}
