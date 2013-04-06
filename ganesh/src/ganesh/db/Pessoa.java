/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotation.Entity;
import ganesh.db.annotation.Field;
import ganesh.db.annotation.Id;

@Entity("pessoa")
public class Pessoa extends AbstractDBEntity {

	@Id("id_pessoa")
	private Integer idPessoa;

	@Field("codigo")
	private String codigo;

	@Field("nome")
	private String nome;

	@Field("documento")
	private String documento;

	@Field("contato")
	private String contato;

	@Field("endereco")
	private String endereco;

	public Pessoa() {}

	public Pessoa(Pessoa other) {
		this.idPessoa = other.idPessoa;
		this.codigo = other.codigo;
		this.nome = other.nome;
		this.documento = other.documento;
		this.contato = other.contato;
		this.endereco = other.endereco;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getContato() {
		return contato;
	}

	public String getEndereco() {
		return endereco;
	}

	protected void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
