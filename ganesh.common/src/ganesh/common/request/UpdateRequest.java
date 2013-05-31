/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.XMLItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UpdateRequest extends Request {

	List<XMLItem> items = new ArrayList<>();

	private String program;
	private String extra;

	public UpdateRequest(String program) {
		this(program, null);
	}

	public UpdateRequest(String program, String extra) {
		this.program = program;
		this.extra = extra;
	}

	public void addItem(XMLItem item) {
		if (item != null)
			items.add(item);
	}

	public List<XMLItem> listItemsToUpdate() {
		return new ArrayList<>(items);
	}

	@Override
	protected String getAction() {
		return "program/" + program + "/save" + (extra == null ? "" : "/" + extra);
	}

	@Override
	protected void write(PrintWriter wr) {
		for (XMLItem item: items)
			if (item != null)
				wr.print(item.toXML());
	}
}
