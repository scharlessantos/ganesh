package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.embed.database.DBServer;
import ganesh.embed.http.HttpServer;
import ganesh.log.FileLogger;

import org.scharlessantos.hermes.Hermes;
import org.scharlessantos.hermes.logger.GenericHFilter;
import org.scharlessantos.hermes.writer.HLevel;

/**
 * Class who starts application
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hermes.removeDefaultFileLogger();
		Hermes.addLogger(new FileLogger(), new GenericHFilter(HLevel.INFO));

		Hermes.info("\n=====================================" +
			"\n          Starting Ganesh" +
			"\n An open source program: NO WARRANTY" +
			"\n=====================================");

		try {
			new DBServer().initDB();
		} catch (GException e) {
			Hermes.fatal("Nao foi possivel iniciar o Banco de Dados");
			Hermes.fatal(e);

			System.exit(1);
		}

		Ganesh.getInstance().start();

		try {
			HttpServer.getInstance().startServer();
		} catch (GException e) {
			Hermes.fatal(e);

			System.exit(2);
		}

	}

}
