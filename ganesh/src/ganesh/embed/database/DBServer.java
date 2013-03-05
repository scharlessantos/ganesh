package ganesh.embed.database;

import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

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

	public void initDB() throws GException {
		Hermes.info("Iniciando Banco de Dados");

		updateDB();

		Hermes.info("Banco de Dados atualizado");
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
				creatOrUpdateDB(conn, "create");

				version = 1;
			}

			for (int i = version; i < dbver; i++) {
				Hermes.info("Atualizando Banco de dados para versão " + (i + 1));
				creatOrUpdateDB(conn, String.format("update.%03d", i));
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new GException(ErrorCode.UNKOWN,
				"Erro ao atualizar o Banco de Dados", e);
		}
	}

	private void validateDBDirectory() throws GException {
		File file = new File("db");

		Hermes.info("Validando o diretorio de dados");

		if (!file.exists())
			if (!file.mkdir())
				throw new GException(ErrorCode.UNKOWN,
					"Não foi possivel criar o diretorio de dados");

		if (!file.isDirectory())
			throw new GException(ErrorCode.UNKOWN,
				"Arquivo existe e não é um diretorio");

		Hermes.info("Diretorio de dados OK!");
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		long time = System.currentTimeMillis();

		Class.forName("org.h2.Driver");

		String connectionString = "jdbc:h2:"
			+ new File(new File("db"), "ganeshdb").getAbsolutePath();

		Connection connection = DriverManager.getConnection(connectionString);
		connection.setAutoCommit(true);
		connection.setReadOnly(true);

		Hermes.info(String.format("Criando conexão: %dms", System.currentTimeMillis() - time));
		return connection;
	}

	/**
	 * Versão do banco de dados, a cada atualização do Banco de Dados, ou seja, mudanças na estrutura, criar script de update e incrementar 1 aqui
	 */
	private final short dbver = 1;

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

				throw new GException(ErrorCode.UNKOWN, "Banco mais novo do que Ganesh espera");
			}

		} catch (SQLException e) {
			if (e.getMessage().toLowerCase().startsWith("table \"dbver\" not found;"))
				return -1;

			throw new GException(ErrorCode.UNKOWN, e);
		}

		return -1;
	}

	private void creatOrUpdateDB(Connection conn, String file) throws GException {
		InputStream res = getRes(file + ".sql");

		if (res == null)
			throw new GException(ErrorCode.UNKOWN, file + ".sql not found");

		try {

			BufferedInputStream reader = new BufferedInputStream(res);
			String command = "";

			byte[] buffer = new byte[reader.available()];
			while (reader.read(buffer) > 0) {
				String linha = new String(buffer);

				if (linha != null)
					command += linha;
			}

			reader.close();
			res.close();

			if (command.isEmpty())
				throw new GException(ErrorCode.UNKOWN, "Arquivo " + file + ".sql está vazio");

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
			throw new GException(ErrorCode.UNKOWN, "Erro ao ler o " + file + ".sql", e);
		} catch (SQLException e) {
			throw new GException(ErrorCode.UNKOWN, "Erro ao criar/Atualizar o o Banco de Dados: " + dbver, e);
		}

	}

	private InputStream getRes(String name) {
		return getClass().getResourceAsStream("maintenance/" + name);
	}
}
