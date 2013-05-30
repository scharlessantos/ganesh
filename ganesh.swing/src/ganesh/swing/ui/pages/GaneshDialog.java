/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.swing.ui.controls.ButtonHandler;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public abstract class GaneshDialog extends GaneshPage {

	private boolean modal = true;
	private int width = 450;
	private int heigth = 550;
	private GString lblFechar;

	public GaneshDialog(boolean modal, int width, int heigth) {
		super();

		this.modal = modal;
		this.width = width;
		this.heigth = heigth;
	}

	protected void setLabelFechar(GString lblFechar) {
		this.lblFechar = lblFechar;
	}

	public void renderize() {
		dialog = new JDialog();
		dialog.setModal(modal);
		dialog.setTitle(getTitle());

		ImageIcon icon = Icons.get(getIcon());
		if (icon != null)
			dialog.setIconImage(icon.getImage());

		dialog.setResizable(false);
		dialog.setContentPane(toJPanel());
		dialog.setSize(width, heigth);

		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	@Override
	protected final JPanel toJPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));

		JToolBar base = new JToolBar();
		base.setFloatable(false);
		base.add(Box.createHorizontalGlue()); //Para que a barra se expanda
		base.addSeparator();

		for (GaneshButton button: listButtons()) {
			base.add(button.render());
			base.addSeparator();
		}

		GaneshButton cancelar = new GaneshButton(lblFechar == null ? GM.fechar() : lblFechar, "ACT_FECHAR", Icons.DECLINE);
		cancelar.setPage(this);

		base.add(cancelar.render());

		panel.add(base, BorderLayout.SOUTH);

		return panel;
	}

	private JDialog dialog;

	@ButtonHandler("ACT_FECHAR")
	public void fechar() throws GException {
		onClose();
		dialog.dispose();
	}

	protected void onClose() throws GException {}

	protected void close() throws GException {
		fechar();
	}
}
