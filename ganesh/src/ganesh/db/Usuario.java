/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;
import ganesh.db.utils.Filter.FilterType;

@Entity("usuario")
public class Usuario extends Pessoa {

	@Id("id_usuario")
	protected Integer idUsuario;

	@Property("username")
	protected String username;

	@Property("senha")
	protected String senha;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public String getSenha() {
		return senha;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Usuario) {
			super.merge(other);

			Usuario us = (Usuario)other;

			if (this.idUsuario == null)
				this.idUsuario = us.idUsuario;

			if (this.username == null)
				this.username = us.username;

			if ((us.senha != null && !us.senha.equals(this.senha)))
				this.senha = us.senha;
		}

		super.merge(other);
	}

	public static Usuario getByUsername(String username) throws GException {
		return DB.first(Usuario.class, new Filter(Usuario.class, "username", username, FilterType.LIKE));
	}
}
