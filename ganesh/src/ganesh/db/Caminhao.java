/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;

@Entity("caminhao")
public class Caminhao extends AbstractDBEntity {

	@Id("id_caminhao")
	protected Long idCaminhao;

	@Property("id_empresa")
	protected Long idEmpresa;

	@Property("codigo")
	protected String codigo;

	@Property("placa")
	protected String placa;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public long getIdCaminhao() {
		return idCaminhao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public Empresa getEmpresa() throws GException {
		if (idEmpresa == null)
			return null;

		return DB.first(Empresa.class, new Filter(Empresa.class, "id_empresa", idEmpresa, FilterType.EQUALS));
	}

	public void setEmpresa(Empresa empresa) {
		if (empresa != null)
			idEmpresa = empresa.getIdEmpresa();
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Caminhao) {

			Caminhao cam = (Caminhao)other;

			if (cam.idCaminhao != null && cam.idCaminhao.equals(idCaminhao)) {

				if (cam.placa != null && !cam.placa.equals(placa))
					codigo = cam.codigo;

				if (cam.placa != null && !cam.codigo.equals(codigo))
					placa = cam.placa;
			}
		}

	}

}
