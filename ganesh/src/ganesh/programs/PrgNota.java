/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.request.Request;
import ganesh.common.response.Response;
import ganesh.programs.ProgramManager.RequestType;

public class PrgNota extends GaneshProgram {

	@Override
	protected String getName() {
		return "nota";
	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp, String extra) {

	}

}
