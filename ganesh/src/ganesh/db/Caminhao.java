/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Aggregated;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("caminhao")
public class Caminhao extends AbstractDBEntity {

	@Aggregated({ "id_empresa" })
	private Empresa empresa;

	@Id("id_caminhao")
	private long idCaminhao;

	@Property("codigo")
	private String codigo;

	@Property("placa")
	private String placa;

	public long getIdEmpresa() {
		return empresa.getIdEmpresa();
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setIdCaminhao(int idCaminhao) {
		this.idCaminhao = idCaminhao;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		// TODO Auto-generated method stub

	}

}
