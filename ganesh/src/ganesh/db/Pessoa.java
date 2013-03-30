/* Ganesh Server, developed in 2013*/
package ganesh.db;

public class Pessoa extends AbstractDBEntity {

	private Integer idPessoa;
	private String codigo;
	private String nome;
	private String documento;
	private String contato;
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

	@_DBField("id_pessoa")
	public Integer getIdPessoa() {
		return idPessoa;
	}

	@_DBField("codigo")
	public String getCodigo() {
		return codigo;
	}

	@_DBField("nome")
	public String getNome() {
		return nome;
	}

	@_DBField("documento")
	public String getDocumento() {
		return documento;
	}

	@_DBField("contato")
	public String getContato() {
		return contato;
	}

	@_DBField("endereco")
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
