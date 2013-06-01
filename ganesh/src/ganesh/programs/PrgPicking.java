/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.XMLItem;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.request.RequestFilter;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Embalagem;
import ganesh.db.Empresa;
import ganesh.db.Picking;
import ganesh.db.PickingProduto;
import ganesh.db.utils.Filter;
import ganesh.programs.ProgramManager.RequestType;

import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class PrgPicking extends GaneshProgram {

	@Override
	protected String getName() {
		return "picking";
	}

	@RequestHandler(RequestType.LIST)
	public void load(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {

				List<Picking> pickings = DB.list(Picking.class);

				for (Picking picking: pickings)
					resp.addListItem("pickings", picking);

			} else if (extra.startsWith("produtos/")) {
				if (extra.endsWith("add/")) {
					List<Embalagem> embalagens = DB.list(Embalagem.class);

					for (Embalagem embalagem: embalagens)
						resp.addListItem("embalagens", new ProdutoToAdd(embalagem));

				} else {
					List<RequestFilter> filters = req.listFilters();

					if (filters.size() <= 0)
						return;

					List<PickingProduto> produtos = DB.list(PickingProduto.class, new Filter(PickingProduto.class, filters.get(0).getField(), filters.get(0).getValue(), filters.get(0).getType()));

					for (PickingProduto produto: produtos)
						resp.addListItem("produtos", produto);

				}
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
		}
	}

	@RequestHandler(RequestType.SAVE)
	public void save(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {
				for (XMLData data: req.listItems()) {
					String codigo = data.get("codigo");
					if (codigo == null || codigo.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.codigo())));
						return;
					}

					String descricao = data.get("descricao");
					if (descricao == null || descricao.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.nome())));
						return;
					}

					Picking picking = null;

					if (data.get("id_picking") != null)
						picking = DB.first(Picking.class, new Filter(Picking.class, "id_picking", data.get("id_picking"), FilterType.EQUALS));
					else {
						if (DB.first(Empresa.class, new Filter(Empresa.class, "codigo", codigo, FilterType.LIKE)) != null) {
							resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.grupo(), M.codigo(), codigo)));
							return;
						}

						picking = new Picking();
					}

					picking.setCodigo(codigo);
					picking.setDescricao(descricao);

					picking.save();
				}

			} else if (extra.startsWith("produtos/")) {

				for (XMLData data: req.listItems()) {
					if (data.get("qtd") == null) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.quantidade())));
						return;
					}

					String embalagem = data.get("id_embalagem");
					String picking = data.get("id_picking");

					PickingProduto pp = DB.first(PickingProduto.class, new Filter(PickingProduto.class, "id_picking", picking, FilterType.EQUALS).and(new Filter(PickingProduto.class, "id_embalagem", embalagem, FilterType.EQUALS)));

					if (pp == null) {
						pp = new PickingProduto();
						pp.setEmbalagem(Embalagem.getById(Long.valueOf(embalagem)));
						pp.setPicking(Picking.getById(Long.valueOf(picking)));

					}

					try {
						pp.setQtd(Long.valueOf(data.get("qtd")));
						pp.save();
					} catch (NumberFormatException e) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.quantidade())));
						resp.setResponseValue(Response.NAO_OK);
					}
				}

			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.setResponseValue(Response.NAO_OK);
		}
	}

	@RequestHandler(RequestType.DELETE)
	public void delete(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {

				for (XMLData data: req.listItems()) {
					Picking picking = null;

					if (data.get("id_picking") != null)
						picking = DB.first(Picking.class, new Filter(Picking.class, "id_picking", data.get("id_picking"), FilterType.EQUALS));

					if (picking == null)
						resp.setMessage(new ErrorMessage(M._naoEncontrado(M.picking())));
					else {
						picking.delete();

						resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.picking())));
					}
				}

			} else if (extra.startsWith("produtos/")) {

				for (XMLData data: req.listItems()) {
					if (data.get("qtd") == null) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.quantidade())));
						return;
					}

					String embalagem = data.get("id_embalagem");
					String picking = data.get("id_picking");

					PickingProduto pp = DB.first(PickingProduto.class, new Filter(PickingProduto.class, "id_picking", picking, FilterType.EQUALS).and(new Filter(PickingProduto.class, "id_embalagem", embalagem, FilterType.EQUALS)));

					if (pp == null) {
						resp.setMessage(new ErrorMessage(M._naoEncontrado(M.produto())));
					} else {
						pp.delete();
						resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.produto())));
					}
				}
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

	private class ProdutoToAdd implements XMLItem {

		private Embalagem embalagem;

		public ProdutoToAdd(Embalagem embalagem) {
			this.embalagem = embalagem;
		}

		@Override
		public String toXML() {
			if (embalagem == null)
				return "<item/>";

			try {
				return "<item id_embalagem='" + embalagem.getIdEmbalagem() + "' embalagem='" + embalagem.getDescricao() + "' qtd='" + embalagem.getQtd() + "' produto='" + embalagem.getProduto().getCodigo() + " - " + embalagem.getProduto().getNome() + "' />";
			} catch (GException e) {
				Hermes.error(e);
			}

			return "<item/>";
		}
	}
}
