/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.scharlessantos.hermes.Hermes;

public class GaneshButton extends GaneshControl<JButton> {

	private String action;
	private String icon;

	public GaneshButton(GString label, String action, String icon) {
		super(label);

		this.action = action;
		this.icon = icon;
	}

	public String getAction() {
		return action;
	}

	public GaneshButton setAction(String action) {
		this.action = action;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public GaneshButton setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	@Override
	public JButton render() {
		JButton button = new JButton(label == null ? null : label.toString());
		button.setIcon(Icons.get(icon));

		if (tooltip != null)
			button.setToolTipText(tooltip.toString());

		button.addActionListener(new MyListener());

		return button;
	}

	private class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (Method method: page.getClass().getMethods())
				if (method.isAnnotationPresent(ButtonHandler.class)) {
					List<Object> params = new ArrayList<>();

					if (method.getAnnotation(ButtonHandler.class).value().equals(action)) {
						if (method.getParameterTypes().length > 0) {

							for (Class<?> param: method.getParameterTypes()) {
								if (param.equals(GaneshData.class))
									params.add(page.getProgram().getData());
							}

							try {
								method.invoke(page, params.toArray());
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
								Hermes.error(e1);
							}

						}

						return;
					}
				}

			Hermes.info(action + " nao tratado em " + page.getTitle());
		}
	}
}
