package ganesh.db;

public class Usuario extends Pessoa {

	private Integer idUsuario;
	private String username;
	private String senha;

	@_DBField("id_usuario")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	@_DBField("username")
	public String getUsername() {
		return username;
	}

	@_DBField("senha")
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
