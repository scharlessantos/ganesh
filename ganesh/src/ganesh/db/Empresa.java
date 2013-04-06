/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotation.Entity;
import ganesh.db.annotation.Field;
import ganesh.db.annotation.Id;

@Entity("empresa")
public class Empresa extends AbstractDBEntity {

	@Id("id_empresa")
	private int idEmpresa;
	@Field("codigo")
	private String codigo;
	@Field("nome")
	private String nome;
	@Field("cnpj")
	private String cnpj;

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

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
