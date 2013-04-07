/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.embed.database.DBServer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.scharlessantos.hermes.Hermes;

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
	public void save() throws GException {
		/*Pessoa pessoa = new Pessoa(this);
		pessoa.save();

		StringBuilder sql = new StringBuilder();
		sql.append("insert into Usuario (id_pessoa, id_usuario, username, senha) values (");
		sql.append(getIdPessoa());
		sql.append(", ");
		sql.append(getIdUsuario());
		sql.append(", ");
		sql.append(getUsername());
		sql.append(", ");
		sql.append(getSenha());
		sql.append(")");

		Connection conn = DBServer.getInstance().getConnection();

		long time = System.currentTimeMillis();

		if (conn == null)
			throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_("Usuario"));

		try {
			conn.createStatement().executeUpdate(sql.toString());
		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_("Usuario"));
		} finally {
			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, sql));
		}*/
		super.save();
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
		StringBuilder sql = new StringBuilder();
		sql.append("select ");

		/*for (String s: getDBEntities(Pessoa.class)) {
			sql.append("P.");
			sql.append(s.toUpperCase());
			sql.append(", ");
		}

		for (String s: getDBEntities(Usuario.class)) {
			sql.append("U.");
			sql.append(s.toUpperCase());
			sql.append(", ");
		}*/

		sql.append("1");
		sql.append(" from Usuario U inner join Pessoa P on (U.ID_PESSOA = P.ID_PESSOA) where upper(U.USERNAME) LIKE '");
		sql.append(username.toUpperCase());
		sql.append("'");

		try {
			ResultSet result = DBServer.getInstance().executeQuery(sql.toString());

			if (result.first()) {
				Usuario usuario = new Usuario();

				return usuario;
			}

		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_("Usuario"));
		}

		return null;
	}
}
