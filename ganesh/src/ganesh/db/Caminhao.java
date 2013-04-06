/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotation.Aggregated;
import ganesh.db.annotation.Entity;
import ganesh.db.annotation.Field;
import ganesh.db.annotation.Id;

@Entity("caminhao")
public class Caminhao extends AbstractDBEntity {

	@Aggregated({ "id_empresa" })
	private Empresa empresa;

	@Id("id_caminhao")
	private int idCaminhao;

	@Field("codigo")
	private String codigo;

	@Field("placa")
	private String placa;

	public int getIdEmpresa() {
		return empresa.getIdEmpresa();
	}

	public int getIdCaminhao() {
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

}
