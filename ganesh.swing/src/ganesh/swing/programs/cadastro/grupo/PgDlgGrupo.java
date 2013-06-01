/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs.cadastro.grupo;

import ganesh.swing.programs.GaneshProgram;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshTextInput;
import ganesh.swing.ui.images.Images.Icons;
import ganesh.swing.ui.pages.GaneshControlPage;
import ganesh.swing.ui.pages.GaneshDialog;

public class PgDlgGrupo extends GaneshDialog {

	public PgDlgGrupo(GaneshProgram program) {
		super(true, 250, 230, program);

		setLabelFechar(GM.cancelar());
		addButton(new GaneshButton(GM.salvar(), "ACT_SALVAR", Icons.DISK));

		setPage(new GaneshControlPage() {

			{
				addControl(new GaneshTextInput("CODIGO", GM.codigo()));
				addControl(new GaneshTextInput("DESCRICAO", GM.nome()));
			}

			@Override
			public String getTitle() {
				return M.adicionar_(M.grupo());
			}

			@Override
			public String getIcon() {
				return Icons.GROUP_ADD;
			}
		});

	}

}
