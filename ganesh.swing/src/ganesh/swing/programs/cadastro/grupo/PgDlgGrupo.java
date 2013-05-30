/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshDialog;

public class PgDlgGrupo extends GaneshDialog {

	public PgDlgGrupo() {
		super(true, 450, 550);

		setLabelFechar(GM.cancelar());
		addButton(new GaneshButton(GM.salvar(), "ACT_SALVAR", Icons.DISK));
	}

	@Override
	public String getTitle() {
		return M.adicionar_(M.grupo());
	}

	@Override
	protected String getIcon() {
		return Icons.GROUP_ADD;
	}

}
