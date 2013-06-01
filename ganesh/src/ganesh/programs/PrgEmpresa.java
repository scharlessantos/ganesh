/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.db.DB;
import ganesh.db.Empresa;
import ganesh.db.utils.Filter;
import ganesh.programs.ProgramManager.RequestType;

import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class PrgEmpresa extends GaneshProgram {

	@Override
	protected String getName() {
		return "empresa";
	}

	@RequestHandler(RequestType.LIST)
	public void list(Request req, Response resp) {
		try {

			List<Empresa> empresas = DB.list(Empresa.class);

			for (Empresa empresa: empresas)
				resp.addListItem("empresas", empresa);

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

	@RequestHandler(RequestType.SAVE)
	public void save(Request req, Response resp) {
		try {

			for (XMLData data: req.listItems()) {
				String codigo = data.get("codigo");
				if (codigo == null || codigo.trim().isEmpty()) {
					resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.codigo())));
					return;
				}

				String nome = data.get("nome");
				if (nome == null || nome.trim().isEmpty()) {
					resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.nome())));
					return;
				}

				String cnpj = data.get("cnpj");
				if (cnpj == null || cnpj.trim().isEmpty()) {
					resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.cnpj())));
					return;
				}

				Empresa empresa;

				if (data.get("id_empresa") != null)
					empresa = DB.first(Empresa.class, new Filter(Empresa.class, "id_empresa", data.get("id_empresa"), FilterType.EQUALS));
				else {
					if (DB.first(Empresa.class, new Filter(Empresa.class, "codigo", codigo, FilterType.LIKE)) != null) {
						resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.empresa(), M.codigo(), codigo)));
						return;
					}

					empresa = new Empresa();
				}

				empresa.setCodigo(codigo);
				empresa.setNome(nome);
				empresa.setCnpj(cnpj);

				empresa.save();
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

	@RequestHandler(RequestType.DELETE)
	public void delete(Request req, Response resp) {
		try {

			for (XMLData data: req.listItems()) {
				Empresa empresa = null;

				if (data.get("id_empresa") != null)
					empresa = DB.first(Empresa.class, new Filter(Empresa.class, "id_empresa", data.get("id_empresa"), FilterType.EQUALS));

				if (empresa == null)
					resp.setMessage(new ErrorMessage(M._naoEncontrado(M.empresa())));
				else {
					empresa.delete();

					resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.empresa())));
				}
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

}
