/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import java.io.PrintWriter;

public class ListRequest extends Request {

	private String program;

	public ListRequest(String program) {
		this.program = program;
	}

	@Override
	protected String getAction() {
		return "program/" + program + "/list";
	}

	@Override
	protected void write(PrintWriter wr) {

	}
}
