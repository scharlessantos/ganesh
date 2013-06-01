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
	private Acao acao;

	public UpdateRequest(Acao acao, String program) {
		this(acao, program, null);
	}

	public UpdateRequest(Acao acao, String program, String extra) {
		this.program = program;
		this.extra = extra;
		this.acao = acao;
	}

	public void addItem(XMLItem item) {
		if (item != null)
			items.add(item);
	}

	public List<XMLItem> listItemsToUpdate() {
		return new ArrayList<>(items);
	}

	public String getProgram() {
		return program;
	}

	public String getExtra() {
		return extra;
	}

	public Acao getAcao() {
		return acao;
	}

	@Override
	protected String getAction() {
		return "program/" + program + "/" + acao.getAcao() + (extra == null ? "" : "/" + extra);
	}

	@Override
	protected void write(PrintWriter wr) {
		for (XMLItem item: items)
			if (item != null)
				wr.print(item.toXML());
	}

	public enum Acao {
		SALVAR("save"),
		DELETAR("delete");

		private String acao;

		private Acao(String acao) {
			this.acao = acao;
		}

		public String getAcao() {
			return acao;
		}

	}
}
