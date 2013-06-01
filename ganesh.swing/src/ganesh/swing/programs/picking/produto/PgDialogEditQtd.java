/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.picking.produto;

import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshTextInput;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshControlPage;
import ganesh.swing.ui.pages.GaneshDialog;

public class PgDialogEditQtd extends GaneshDialog {

	public PgDialogEditQtd(GaneshProgram program) {
		super(true, 250, 300, program);

		setPage(new GaneshControlPage() {

			{
				addControl(new GaneshTextInput("PRODUTO", GM.produto()).setReadOnly(true));
				addControl(new GaneshTextInput("QTD", GM.quantidade()));
			}

			@Override
			public String getTitle() {
				return M.alterarQuantidade();
			}

			@Override
			public String getIcon() {
				return Icons.BRICKS;
			}
		});

		setLabelFechar(GM.cancelar());

		addButton(new GaneshButton(GM.salvar(), "SALVAR", Icons.DISK));
	}
}
