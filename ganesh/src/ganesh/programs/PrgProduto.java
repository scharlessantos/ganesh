/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Produto;
import ganesh.db.utils.Filter;
import ganesh.db.utils.Filter.FilterType;
import ganesh.programs.ProgramManager.RequestType;

import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class PrgProduto extends GaneshProgram {

	@Override
	protected String getName() {
		return "produto";
	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {
				List<Produto> produtos = DB.list(Produto.class);

				for (Produto produto: produtos)
					resp.addListItem("produtos", produto);

			} else if (extra.equals("embalagem")) {

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

					Produto produto;

					if (data.get("id_produto") != null)
						produto = DB.first(Produto.class, new Filter(Produto.class, "id_produto", data.get("id_produto"), FilterType.EQUALS));
					else {
						if (DB.first(Produto.class, new Filter(Produto.class, "codigo", codigo, FilterType.LIKE)) != null) {
							resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.produto(), M.codigo(), codigo)));
							return;
						}

						produto = new Produto();
					}

					produto.setCodigo(codigo);
					produto.setNome(data.get("nome"));
					produto.setComplemento(data.get("complemento"));
					produto.setPesavel(data.get("pesavel").endsWith("true"));

					produto.save();
				}

			}
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

	@RequestHandler(RequestType.DELETE)
	public void delete(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {

				for (XMLData data: req.listItems()) {
					Produto produto = null;

					if (data.get("id_produto") != null)
						produto = DB.first(Produto.class, new Filter(Produto.class, "id_produto", data.get("id_produto"), FilterType.EQUALS));

					if (produto == null)
						resp.setMessage(new ErrorMessage(M._naoEncontrado(M.produto())));
					else {
						produto.delete();

						resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.produto())));
					}
				}

			}
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}
}
