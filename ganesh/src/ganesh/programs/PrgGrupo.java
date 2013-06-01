/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.common.request.Request;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Empresa;
import ganesh.db.Grupo;
import ganesh.db.utils.Filter;
import ganesh.programs.ProgramManager.RequestType;

import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class PrgGrupo extends GaneshProgram {

	public static final String NAME = "GANESH_GRUPO";
	public static final GString TITLE = GM.grupos();
	public static final String ICON = "users";
	public static final String ROLE = null;

	@Override
	protected String getName() {
		return "grupo";
	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.isEmpty()) {
				List<Grupo> grupos = DB.list(Grupo.class);

				for (Grupo grupo: grupos)
					resp.addListItem("grupos", grupo);

			}
		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.setResponseValue(Response.NAO_OK);
		}

	}

	@RequestHandler(RequestType.SAVE)
	public void save(Request req, Response resp) {
		try {

			for (XMLData data: req.listItems()) {
				String codigo = data.get("codigo");
				if (codigo == null || codigo.trim().isEmpty()) {
					resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.codigo())));
					resp.setResponseValue(Response.NAO_OK);
					return;
				}

				String descricao = data.get("descricao");
				if (descricao == null || descricao.trim().isEmpty()) {
					resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.nome())));
					resp.setResponseValue(Response.NAO_OK);
					return;
				}

				Grupo grupo;

				if (data.get("id_grupo") != null)
					grupo = DB.first(Grupo.class, new Filter(Grupo.class, "id_grupo", data.get("id_grupo"), FilterType.EQUALS));
				else {
					if (DB.first(Empresa.class, new Filter(Empresa.class, "codigo", codigo, FilterType.LIKE)) != null) {
						resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.grupo(), M.codigo(), codigo)));
						resp.setResponseValue(Response.NAO_OK);
						return;
					}

					grupo = new Grupo();
				}

				grupo.setCodigo(codigo);
				grupo.setNome(descricao);

				grupo.save();
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.setResponseValue(Response.NAO_OK);
		}
	}

	@RequestHandler(RequestType.DELETE)
	public void delete(Request req, Response resp) {
		try {

			for (XMLData data: req.listItems()) {
				Grupo grupo = null;

				if (data.get("id_grupo") != null)
					grupo = DB.first(Grupo.class, new Filter(Grupo.class, "id_grupo", data.get("id_grupo"), FilterType.EQUALS));

				if (grupo == null)
					resp.setMessage(new ErrorMessage(M._naoEncontrado(M.grupo())));
				else {
					grupo.delete();

					resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.grupo())));
				}
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

}
