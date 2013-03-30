/* Ganesh Server, developed in 2013*/
package ganesh.db;

public class Empresa extends AbstractDBEntity {

	private int idEmpresa;
	private String codigo;
	private String nome;
	private String cnpj;

	@_DBField("id_empresa")
	public int getIdEmpresa() {
		return idEmpresa;
	}

	@_DBField("codigo")
	public String getCodigo() {
		return codigo;
	}

	@_DBField("nome")
	public String getNome() {
		return nome;
	}

	@_DBField("cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
