/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Empresa;
import ganesh.db.Picking;
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
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
		}
	}

	@RequestHandler(RequestType.DELETE)
	public void delete(Request req, Response resp, String extra) {

	}

}
