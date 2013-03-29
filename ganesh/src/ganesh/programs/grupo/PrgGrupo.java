/* Ganesh Server, developed in 2013*/
package ganesh.programs.grupo;

import ganesh.common.i18n.GString;
import ganesh.common.request.Request;
import ganesh.common.response.Response;
import ganesh.programs.GaneshProgram;
import ganesh.programs.ProgramManager.RequestType;
import ganesh.programs.RequestHandler;

public class PrgGrupo extends GaneshProgram {

	public static final String NAME = "GANESH_GRUPO";
	public static final GString TITLE = GM.grupos();
	public static final String ICON = "users";
	public static final String ROLE = null;

	public PrgGrupo() {

	}

	@RequestHandler(RequestType.LIST)
	public void save(Request req, Response resp) {

	}

}
