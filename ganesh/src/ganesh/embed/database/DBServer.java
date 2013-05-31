/* Ganesh Server, developed in 2013*/
package ganesh.embed.database;

import ganesh.Ganesh;
import ganesh.common.exceptions.GException;
import ganesh.db.Usuario;
import ganesh.exception.ServerErrorCode;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.scharlessantos.hermes.Hermes;

public class DBServer {

	private static DBServer instance;

	protected Messages M = Ganesh.getMessages();
	protected GMessages GM = Ganesh.getGMessages();

	public static DBServer getInstance() {
		if (instance == null)
			instance = new DBServer();

		return instance;
	}

	private DBServer() {}

	public void initDB() throws GException {
		Hermes.info("Iniciando Banco de Dados");

		updateDB();

		Hermes.info("Banco de Dados atualizado");

		try {
			Hermes.info("Verificando Usuário root");
			Usuario usuario = Usuario.getByUsername("root");

			if (usuario == null) {
				Hermes.info("Criando Usuário root");
				usuario = new Usuario();
				usuario.setCodigo("root");
				usuario.setNome("Super Usuário");
				usuario.setContato("root@ganesh");
				usuario.setDocumento("GANESH");
				usuario.setEndereco("R. India");
				usuario.setSenha("123456");
				usuario.setUsername("root");
				usuario.save();

			}

		} catch (GException e) {
			Hermes.error(e);
		}
	}

	private final String MODULE = "ganesh";

	private void updateDB() throws GException {
		validateDBDirectory();
		try {
			Connection conn = getConnection();

			int version = validateDBVer(conn, MODULE);

			if (version == 0)
				return;

			if (version == -1) {
				Hermes.info("Banco de dados não existe, criando...");
				createOrUpdateDB(conn, "create");

				version = 1;
			}

			for (int i = version; i < dbver; i++) {
				Hermes.info("Atualizando Banco de dados para versão " + (i + 1));
				createOrUpdateDB(conn, String.format("update.%03d", i));
			}

		} catch (GException e) {
			throw new GException(ServerErrorCode.DB_UPDATE, GM.erroAoAtualizarOBancoDeDados(), e);
		}
	}

	private void validateDBDirectory() throws GException {
		File file = new File("db");

		Hermes.info("Validando o diretorio de dados");

		if (!file.exists())
			if (!file.mkdir())
				throw new GException(ServerErrorCode.DB_UPDATE, GM.naoFoiPossivelCriarODiretorioDeDados());

		if (!file.isDirectory())
			throw new GException(ServerErrorCode.DB_UPDATE, GM.arquivoDeDadosExistePoremNaoEhUmDiretorio());

		Hermes.info("Diretorio de dados OK!");
	}

	public Connection getConnection() throws GException {
		long time = System.currentTimeMillis();

		try {
			Class.forName("org.h2.Driver");

			String connectionString = "jdbc:h2:" + new File(new File("db"), "ganeshdb").getAbsolutePath();

			Connection connection = DriverManager.getConnection(connectionString);
			connection.setAutoCommit(true);

			Hermes.info(String.format("Criando conexão: %dms", System.currentTimeMillis() - time));

			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			throw new GException(ServerErrorCode.DB_ERROR, e);
		}
	}

	public ResultSet executeQuery(String sql) throws GException {
		return executeQuery(getConnection(), sql);
	}

	public ResultSet executeQuery(Connection conn, String sql) throws GException {
		if (conn == null)
			throw new GException(ServerErrorCode.DB_ERROR, M.erroAoInserir_("Usuario"));

		long time = System.currentTimeMillis();
		try {
			return conn.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ServerErrorCode.DB_ERROR, e);
		} finally {
			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, sql));
		}

	}

	public void executeUpdate(String sql) throws GException {
		Connection conn = getConnection();

		long time = System.currentTimeMillis();
		try {
			conn.prepareStatement(sql).executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ServerErrorCode.DB_ERROR, e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				Hermes.error(e);
			}
			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, sql));
		}

	}

	/**
	 * Versão do banco de dados, a cada atualização do Banco de Dados, ou seja, mudanças na estrutura, criar script de update e incrementar 1 aqui
	 */
	private final int dbver = new File("bin/ganesh/embed/database/maintenance").list().length;

	private int validateDBVer(Connection conn, String module) throws GException {

		try {
			long time = System.currentTimeMillis();
			ResultSet result = conn.prepareStatement("Select version from dbver where module like '" + module + "'").executeQuery();
			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, "Select version from dbver where module like '" + module + "'"));

			while (result.next()) {
				int version = result.getShort("version");

				if (dbver == version)
					return 0;

				if (dbver > version)
					return version;

				throw new GException(ServerErrorCode.DB_UPDATE, GM.bancoMaisNovoDoQueGaneshEspera());
			}

		} catch (SQLException e) {
			if (e.getMessage().toLowerCase().startsWith("table \"dbver\" not found;"))
				return -1;

			throw new GException(ServerErrorCode.DB_UPDATE, e);
		}

		return -1;
	}

	private void createOrUpdateDB(Connection conn, String file) throws GException {
		InputStream res = getRes(file + ".sql");

		if (res == null)
			throw new GException(ServerErrorCode.DB_UPDATE, file + ".sql not found");

		try {

			BufferedInputStream reader = new BufferedInputStream(res);
			String command = "";

			byte[] buffer = new byte[reader.available()];
			while (reader.read(buffer) > 0) {
				String linha = new String(buffer);

				command += linha;
			}

			reader.close();
			res.close();

			if (command.isEmpty())
				throw new GException(ServerErrorCode.DB_UPDATE, "Arquivo " + file + ".sql está vazio");

			long time = System.currentTimeMillis();

			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.prepareStatement(command).execute();

			if (file.equals("create"))
				conn.prepareStatement("Insert into dbver (module, version) values ('" + MODULE + "', " + dbver + ")").execute();
			else
				conn.prepareStatement("update dbver set version =" + dbver + " where module like '" + MODULE + "'").execute();

			conn.commit();

			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, "script " + file + ".sql"));
		} catch (IOException e) {
			throw new GException(ServerErrorCode.DB_UPDATE, "Erro ao ler o " + file + ".sql", e);
		} catch (SQLException e) {
			Hermes.error(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				Hermes.error(e1);
			}
			throw new GException(ServerErrorCode.DB_UPDATE, "Erro ao criar/Atualizar o o Banco de Dados: " + dbver, e);
		}

	}

	private InputStream getRes(String name) {
		return getClass().getResourceAsStream("maintenance/" + name);
	}
}
