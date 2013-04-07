/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("pessoa")
public class Pessoa extends AbstractDBEntity {

	@Id("id_pessoa")
	protected Integer idPessoa;

	@Property("codigo")
	protected String codigo;

	@Property("nome")
	protected String nome;

	@Property("documento")
	protected String documento;

	@Property("contato")
	protected String contato;

	@Property("endereco")
	protected String endereco;

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

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Pessoa) {

			Pessoa pessoa = (Pessoa)other;

			if (this.idPessoa == null)
				this.idPessoa = pessoa.idPessoa;

			if ((pessoa.codigo != null && !pessoa.codigo.equals(this.codigo)))
				this.codigo = pessoa.codigo;

			if ((pessoa.nome != null && !pessoa.nome.equals(this.nome)))
				this.nome = pessoa.nome;

			if ((pessoa.codigo != null && !pessoa.codigo.equals(this.codigo)))
				this.codigo = pessoa.codigo;

			if ((pessoa.documento != null && !pessoa.documento.equals(this.documento)))
				this.documento = pessoa.documento;

			if ((pessoa.contato != null && !pessoa.contato.equals(this.contato)))
				this.contato = pessoa.contato;

			if ((pessoa.endereco != null && !pessoa.endereco.equals(this.endereco)))
				this.endereco = pessoa.endereco;
		}

	}

}
