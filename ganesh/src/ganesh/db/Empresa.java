/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("empresa")
public class Empresa extends AbstractDBEntity {

	@Id("id_empresa")
	protected Long idEmpresa;

	@Property("codigo")
	protected String codigo;

	@Property("nome")
	protected String nome;

	@Property("cnpj")
	protected String cnpj;

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
		if (other instanceof Empresa) {
			Empresa emp = (Empresa)other;

			if (emp.idEmpresa != null && emp.idEmpresa.equals(idEmpresa)) {

				if (emp.codigo != null && !emp.codigo.equals(codigo))
					codigo = emp.codigo;

				if (emp.nome != null && !emp.nome.equals(nome))
					nome = emp.nome;

				if (emp.cnpj != null && !emp.cnpj.equals(cnpj))
					cnpj = emp.cnpj;

			}
		}
	}
}
