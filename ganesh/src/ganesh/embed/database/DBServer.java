package ganesh.embed.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ganesh.exceptions.ErrorCode;
import ganesh.exceptions.GException;

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
				createDB(conn);
			} else {

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
	 * Versão do banco de dados, a cada atualização do Banco de Dados, ou seja,
	 * mudanças na estrutura, criar script de update e incrementar 1 aqui
	 */
	private final short dbver = 1;

	private int validateDBVer(Connection conn, String module) throws GException {
		try {
			long time = System.currentTimeMillis();
			ResultSet result = conn.prepareStatement("Select version from dbver where module like '" + module	+ "'").executeQuery();

			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, "Select version from dbver where module like '" + module	+ "'"));
			
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

	private void createDB(Connection conn) throws GException{
		Hermes.info("Banco de Dados não existe, criando...");
		
		URL url = getRes("create");
		
		if (url==null || url.getPath() == null || url.getPath().isEmpty())
			throw new GException(ErrorCode.UNKOWN, "create.sql not found");
		
		try {
			FileReader reader = new FileReader(url.getPath());
			BufferedReader leitor = new BufferedReader(reader);
			
			String command = "";
			
			String linha = null;
			while ((linha = leitor.readLine()) != null){
				if (linha.isEmpty() || linha.startsWith("--"))
					continue;
				
				command += linha + "\n";
			}
			
			leitor.close();
			
			if (command.isEmpty())
				throw new GException(ErrorCode.UNKOWN, "Arquivo create.sql está vazio");
			
			long time = System.currentTimeMillis();
			
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.prepareStatement(command).execute();
			conn.prepareStatement("Insert into dbver (module, version) values ('" + MODULE + "', " + dbver + ")").execute();
			conn.commit();
			
			Hermes.info(String.format("SQL Time: %dms -> %s", System.currentTimeMillis() - time, "script create.sql"));
		} catch (IOException e) {
			throw new GException(ErrorCode.UNKOWN, "Erro ao ler o create.sql", e);
		} catch (SQLException e) {
			throw new GException(ErrorCode.UNKOWN, "Erro ao criar o Banco de Dados", e);
		}
		
	}
	
	private URL getRes(String name) {
		return getClass().getResource("maintenance/" + name + ".sql");
	}
}
