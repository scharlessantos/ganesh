/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.request.Request;
import ganesh.common.response.Response;
import ganesh.common.response.ResponseItem;
import ganesh.programs.ProgramManager.RequestType;

public class PrgNota extends GaneshProgram {

	@Override
	protected String getName() {
		return "nota";
	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp, String extra) {

		if (extra == null || extra.isEmpty()) {
			resp.addListItem("notas", new FakeNota("nota001", "Mercearia  do José"));
			resp.addListItem("notas", new FakeNota("nota002", "Mercearia  do José"));
			resp.addListItem("notas", new FakeNota("nota003", "Mercearia  do José"));
		} else {
			resp.addListItem("produtos", new FakeProduto("p001", "Coca-cola 2l", "25"));
			resp.addListItem("produtos", new FakeProduto("p002", "Coca-cola 1.5l", "10"));
			resp.addListItem("produtos", new FakeProduto("p003", "Vedete taubaina 2l", "50"));
		}

	}

	private static class FakeNota implements ResponseItem {

		private String codigo = "";
		private String cliente = "";

		public FakeNota(String codigo, String cliente) {
			this.codigo = codigo;
			this.cliente = cliente;
		}

		@Override
		public String toXML() {
			return "<nota codigo='" + codigo + "' cliente='" + cliente + "'/>";
		}

	}

	private static class FakeProduto implements ResponseItem {

		private String codigo = "";
		private String nome = "";
		private String qtd = "";

		public FakeProduto(String codigo, String nome, String qtd) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.qtd = qtd;
		}

		@Override
		public String toXML() {
			return "<nota codigo='" + codigo + "' nome='" + nome + "' qtd='" + qtd + "' />";
		}

	}
}
