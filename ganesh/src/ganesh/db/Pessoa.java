package ganesh.db;

public class Pessoa extends AbstractDBEntity {

	private Integer idPessoa;
	private String codigo;
	private String nome;
	private String documento;
	private String contato;
	private String endereco;

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
