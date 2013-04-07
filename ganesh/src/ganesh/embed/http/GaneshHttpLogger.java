/* Ganesh Server, developed in 2013*/
package ganesh.embed.http;

import org.eclipse.jetty.util.log.Logger;
import org.scharlessantos.hermes.Hermes;

public class GaneshHttpLogger implements Logger {

	private final String name;
	private boolean debug = false;

	public GaneshHttpLogger() {
		this("GaneshHTTPLogger");
	}

	public GaneshHttpLogger(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void warn(String msg, Object... args) {
		Hermes.warn(msg, args);
	}

	@Override
	public void warn(Throwable thrown) {
		Hermes.warn(thrown);
	}

	@Override
	public void warn(String msg, Throwable thrown) {
		Hermes.warn(msg);
		Hermes.warn(thrown);
	}

	@Override
	public void info(String msg, Object... args) {
		if (debug)
			Hermes.info(msg, args);
	}

	@Override
	public void info(Throwable thrown) {
		Hermes.info(thrown);
	}

	@Override
	public void info(String msg, Throwable thrown) {
		Hermes.info(msg);
		Hermes.info(thrown);
	}

	@Override
	public boolean isDebugEnabled() {
		return debug;
	}

	@Override
	public void setDebugEnabled(boolean enabled) {
		this.debug = enabled;
	}

	@Override
	public void debug(String msg, Object... args) {
		if (debug)
			Hermes.debug(msg, args);
	}

	@Override
	public void debug(Throwable thrown) {
		Hermes.debug(thrown);
	}

	@Override
	public void debug(String msg, Throwable thrown) {
		Hermes.debug(msg);
		Hermes.debug(thrown);
	}

	@Override
	public Logger getLogger(String name) {
		GaneshHttpLogger logger = new GaneshHttpLogger();
		logger.setDebugEnabled(debug);
		return logger;
	}

	@Override
	public void ignore(Throwable ignored) {
		Hermes.info("Jetty ignored");
		Hermes.info(ignored);
	}

}
