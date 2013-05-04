/* Ganesh Server, developed in 2013*/
package ganesh.programs.grupo;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.common.request.Request;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Grupo;
import ganesh.programs.GaneshProgram;
import ganesh.programs.ProgramManager.RequestType;
import ganesh.programs.RequestHandler;

import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class PrgGrupo extends GaneshProgram {

	public static final String NAME = "GANESH_GRUPO";
	public static final GString TITLE = GM.grupos();
	public static final String ICON = "users";
	public static final String ROLE = null;

	public PrgGrupo() {

	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.isEmpty()) {
				List<Grupo> grupos = DB.list(Grupo.class);

				for (Grupo grupo: grupos)
					resp.addListItem("grupos", grupo);

			}
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
		}

	}

	@RequestHandler(RequestType.SAVE)
	public void save(Request req, Response resp, String o) {

	}

}
