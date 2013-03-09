/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.programs.grupo;

import ganesh.common.request.Request;
import ganesh.common.response.Response;
import ganesh.programs.GaneshProgram;
import ganesh.programs.ProgramManager.RequestType;
import ganesh.programs.RequestHandler;

public class PrgGrupo extends GaneshProgram {

	public static final String NAME = "GANESH_GRUPO";
	public static final String TITLE = "Grupos";
	public static final String ICON = "users";
	public static final String ROLE = null;

	public PrgGrupo() {

	}

	@RequestHandler(RequestType.LIST)
	public void save(Request req, Response resp) {

	}

}
