/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.common.XMLData;
import ganesh.common.exceptions.GException;
import ganesh.common.request.Request;
import ganesh.common.request.RequestFilter;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Message.InformationMessage;
import ganesh.common.response.Response;
import ganesh.db.Caminhao;
import ganesh.db.DB;
import ganesh.db.Empresa;
import ganesh.db.Motorista;
import ganesh.db.Pessoa;
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
	public void list(Request req, Response resp, String extra) {
		try {
			if (extra == null || extra.trim().isEmpty()) {
				List<Empresa> empresas = DB.list(Empresa.class);

				for (Empresa empresa: empresas)
					resp.addListItem("empresas", empresa);

			} else if (extra.startsWith("caminhao/")) {
				List<RequestFilter> filters = req.listFilters();

				if (filters.size() <= 0)
					return;

				List<Caminhao> caminhoes = DB.list(Caminhao.class, new Filter(Caminhao.class, filters.get(0).getField(), filters.get(0).getValue(), filters.get(0).getType()));

				for (Caminhao caminhao: caminhoes)
					resp.addListItem("caminhoes", caminhao);

			} else if (extra.startsWith("motorista/")) {
				List<RequestFilter> filters = req.listFilters();

				if (filters.size() <= 0)
					return;

				List<Motorista> motoristas = DB.list(Motorista.class, new Filter(Motorista.class, filters.get(0).getField(), filters.get(0).getValue(), filters.get(0).getType()));

				for (Motorista motorista: motoristas)
					resp.addListItem("motoristas", motorista);
			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));
			resp.setResponseValue(Response.NAO_OK);
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

			} else if (extra.startsWith("caminhao/")) {
				for (XMLData data: req.listItems()) {
					String empresa = data.get("id_empresa");
					if (empresa == null || empresa.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.empresa())));
						return;
					}

					String codigo = data.get("codigo");
					if (codigo == null || codigo.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.codigo())));
						return;
					}

					Caminhao caminhao = null;

					if (data.get("id_caminhao") != null)
						caminhao = DB.first(Caminhao.class, new Filter(Caminhao.class, "id_caminhao", data.get("id_caminhao"), FilterType.EQUALS));
					else if (DB.first(Caminhao.class, new Filter(Caminhao.class, "codigo", codigo, FilterType.LIKE)) != null) {
						resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.caminhao(), M.codigo(), codigo)));
						return;
					}

					if (caminhao == null) {
						caminhao = new Caminhao();
						caminhao.setEmpresa(DB.first(Empresa.class, new Filter(Empresa.class, "id_empresa", empresa, FilterType.EQUALS)));
					}

					caminhao.setCodigo(codigo);
					caminhao.setPlaca(data.get("placa"));
					caminhao.save();

				}
			} else if (extra.startsWith("motorista/")) {
				for (XMLData data: req.listItems()) {
					String empresa = data.get("id_empresa");
					if (empresa == null || empresa.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.empresa())));
						return;
					}

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

					String documento = data.get("documento");
					if (documento == null || documento.trim().isEmpty()) {
						resp.setMessage(new ErrorMessage(M._EhObrigatorio(M.documento())));
						return;

					}
					Motorista motorista = null;

					if (data.get("id_motorista") != null)
						motorista = DB.first(Motorista.class, new Filter(Motorista.class, "id_motorista", data.get("id_motorista"), FilterType.EQUALS));
					else if (DB.first(Motorista.class, new Filter(Pessoa.class, "codigo", codigo, FilterType.LIKE)) != null) {
						resp.setMessage(new ErrorMessage(M._jahCadastradoCom_IgualA_(M.motorista(), M.codigo(), codigo)));
						return;
					}

					if (motorista == null) {
						motorista = new Motorista();
						motorista.setEmpresa(DB.first(Empresa.class, new Filter(Empresa.class, "id_empresa", empresa, FilterType.EQUALS)));
					}

					motorista.setCodigo(codigo);
					motorista.setNome(nome);
					motorista.setDocumento(documento);
					motorista.setContato(data.get("contato"));
					motorista.setEndereco(data.get("endereco"));

					motorista.save();

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

			} else if (extra.startsWith("caminhao")) {
				for (XMLData data: req.listItems()) {

					Caminhao caminhao = null;

					if (data.get("id_empresa") != null)
						caminhao = DB.first(Caminhao.class, new Filter(Caminhao.class, "id_empresa", data.get("id_empresa"), FilterType.EQUALS));

					if (caminhao == null)
						resp.setMessage(new ErrorMessage(M._naoEncontrado(M.caminhao())));
					else {
						caminhao.delete();

						resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.caminhao())));

					}
				}

			} else if (extra.startsWith("motorista")) {
				for (XMLData data: req.listItems()) {

					Motorista motorista = null;

					if (data.get("id_empresa") != null)
						motorista = DB.first(Motorista.class, new Filter(Motorista.class, "id_empresa", data.get("id_empresa"), FilterType.EQUALS));

					if (motorista == null)
						resp.setMessage(new ErrorMessage(M._naoEncontrado(M.motorista())));
					else {
						motorista.delete();

						resp.setMessage(new InformationMessage(M._apagadoComSucesso(M.motorista())));
					}
				}

			}

		} catch (GException e) {
			Hermes.error(e);
			resp.setMessage(new ErrorMessage(e.getMessage()));

		}
	}

}
