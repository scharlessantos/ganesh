/* Ganesh Server, developed in 2013*/
package ganesh.db;

public class Caminhao extends AbstractDBEntity {

	private Empresa empresa;
	private int idCaminhao;
	private String codigo;
	private String placa;

	@_DBField("id_empresa")
	public int getIdEmpresa() {
		return empresa.getIdEmpresa();
	}

	@_DBField("id_caminhao")
	public int getIdCaminhao() {
		return idCaminhao;
	}

	@_DBField("codigo")
	public String getCodigo() {
		return codigo;
	}

	@_DBField("placa")
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
