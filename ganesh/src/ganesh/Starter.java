/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.embed.database.DBServer;
import ganesh.embed.http.HttpServer;
import ganesh.log.FileLogger;

import org.scharlessantos.hermes.HConfiguration;
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
		HConfiguration.getInstance().setBaseFormat("[S:%-5s] %s.%s(%s:%d)@Thread %d:");
		Hermes.removeDefaultFileLogger();
		Hermes.addLogger(new FileLogger(), new GenericHFilter(HLevel.INFO));

		Hermes.info("\n=====================================" +
			"\n          Starting Ganesh" +
			"\n An open source program: NO WARRANTY" +
			"\n=====================================");

		try {
			DBServer.getInstance().initDB();
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
