/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("empresa")
public class Empresa extends AbstractDBEntity {

	@Id("id_empresa")
	private long idEmpresa;
	@Property("codigo")
	private String codigo;
	@Property("nome")
	private String nome;
	@Property("cnpj")
	private String cnpj;

	public long getIdEmpresa() {
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

	@Override
	protected void merge(AbstractDBEntity other) {
		// TODO Auto-generated method stub

	}

}
