/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.controls.AbstractGaneshControl;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public abstract class GaneshControlPage extends GaneshPage {

	private List<AbstractGaneshControl<? extends JComponent>> controls = new ArrayList<>();

	public GaneshControlPage addControl(AbstractGaneshControl<? extends JComponent> control) {
		if (control != null)
			controls.add(control);

		return this;
	}

	@Override
	protected JPanel toJPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;

		int i = 1;
		for (AbstractGaneshControl<? extends JComponent> control: controls)
			if (control != null) {

				JComponent component = control.render();

				c.gridx = 0;
				c.gridy = i;

				c.insets = new Insets(4, 10, 4, 10);

				panel.add(component, c);

				i++;
			}

		panel.doLayout();
		return panel;
	}

	@Override
	public GaneshData getData() {
		if (data == null)
			data = new GaneshData();

		for (AbstractGaneshControl<? extends JComponent> control: controls)
			if (control.isResponsible())
				data.setObject(control.getName(), control.get());

		return data;
	}

	@Override
	public void setData(GaneshData data) {
		super.setData(data);

		if (data != null)
			for (AbstractGaneshControl<? extends JComponent> control: controls)
				if (control.isResponsible())
					control.set(data.get(control.getName()));

	}
}
