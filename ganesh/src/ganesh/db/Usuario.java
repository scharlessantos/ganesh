package ganesh.db;

public class Usuario extends Pessoa {

	private Integer idUsuario;
	private String username;
	private String senha;

	@_XMLField("id_usuario")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	@_XMLField("username")
	public String getUsername() {
		return username;
	}

	@_XMLField("senha")
	public String getSenha() {
		return senha;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
