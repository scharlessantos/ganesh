/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import java.io.PrintWriter;

public class ListRequest extends Request {

	private String program;
	private String extra;

	public ListRequest(String program) {
		this.program = program;
	}

	public ListRequest(String program, String extra) {
		this.program = program;
		this.extra = extra;
	}

	@Override
	protected String getAction() {
		return "program/" + program + "/list" + (extra == null ? "" : "/" + extra);
	}

	@Override
	protected void write(PrintWriter wr) {

	}
}
