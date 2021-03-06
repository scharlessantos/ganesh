/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.swing.GaneshSwing;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.scharlessantos.hermes.Hermes;

public class GaneshButton extends AbstractGaneshControl<JButton> {

	private String action;
	private String icon;
	private GString confirmation;

	public GaneshButton(GString label, String action, String icon) {
		super("", label);

		this.action = action;
		this.icon = icon;
	}

	public GString getConfirmation() {
		return confirmation;
	}

	public GaneshButton setConfirmation(GString confirmation) {
		this.confirmation = confirmation;
		return this;
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
	public boolean isResponsive() {
		return false;
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

						if (getConfirmation() != null)
							if (JOptionPane.showConfirmDialog(null, getConfirmation().toString(), GaneshSwing.getMessages().ganeshClient(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
								return;

						if (method.getParameterTypes().length > 0) {

							for (Class<?> param: method.getParameterTypes()) {
								if (param.equals(GaneshData.class))
									params.add(page.getData());
							}

						}

						try {
							method.invoke(page, params.toArray());
						} catch (Exception e1) {
							Hermes.error(e1);

							if (e1.getCause() != null && e1.getCause() instanceof GException)
								MessageHandler.show(new ErrorMessage(e1.getCause().getMessage()));
						}

						return;
					}
				}

			Hermes.info(String.format("Botão %s não tratado em %s: %s", action, page.getTitle(), page.getClass().getName()));
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface ButtonHandler {

		String value();
	}
}
