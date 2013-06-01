/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public abstract class GaneshDialog extends AbstractGaneshPage {

	private boolean modal = true;
	private int width = 450;
	private int heigth = 550;
	private GString lblFechar;

	public GaneshDialog(boolean modal, int width, int heigth, GaneshProgram program) {
		super();

		this.modal = modal;
		this.width = width;
		this.heigth = heigth;

		setProgram(program);
	}

	protected void setLabelFechar(GString lblFechar) {
		this.lblFechar = lblFechar;
	}

	protected GaneshPage page;

	protected void setPage(GaneshPage page) {
		this.page = page;

		if (this.page != null)
			this.page.setProgram(getProgram());
	}

	@Override
	public void renderize() {
		dialog = new JDialog();
		dialog.setModal(modal);
		dialog.setResizable(false);
		dialog.setTitle(getTitle());
		dialog.setSize(width, heigth);

		ImageIcon icon = Icons.get(getIcon());
		if (icon != null)
			dialog.setIconImage(icon.getImage());

		dialog.add(toJPanel());
		dialog.doLayout();

		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	@Override
	public final String getTitle() {
		if (page != null)
			return page.getTitle();

		return M.ganeshClient();
	}

	@Override
	public final String getIcon() {
		if (page != null)
			return page.getIcon();

		return Icons.APPLICATION_FORM;
	}

	protected final JPanel toJPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));

		if (page != null)
			panel.add(page.render(), BorderLayout.CENTER);

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
		panel.doLayout();
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

	@Override
	public GaneshData getData() {
		if (page == null)
			return null;

		return page.getData();
	}

	@Override
	public void setData(GaneshData data) {
		if (page != null)
			page.setData(data);

		super.setData(data);
	}
}
