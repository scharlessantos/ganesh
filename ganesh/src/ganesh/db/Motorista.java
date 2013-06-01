/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;

@Entity("motorista")
public class Motorista extends Pessoa {

	@Id("id_motorista")
	protected Long idMotorista;

	@Property("id_empresa")
	protected Long idEmpresa;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public long getIdMotorista() {
		return idMotorista;
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

}
