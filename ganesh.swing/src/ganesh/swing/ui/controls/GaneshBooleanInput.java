/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;

import javax.swing.JCheckBox;

public class GaneshBooleanInput extends AbstractGaneshControl<JCheckBox> {

	public GaneshBooleanInput(String name, GString label) {
		super(name, label);
	}

	private JCheckBox check;

	@Override
	public JCheckBox render() {
		return check = new JCheckBox(label == null ? "" : label.toString());
	}

	@Override
	public boolean isResponsible() {
		return true;
	}

	@Override
	public Object get() {
		if (check != null)
			return check.isSelected();

		return null;
	}
}
