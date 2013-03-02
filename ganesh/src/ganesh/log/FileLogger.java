package ganesh.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.scharlessantos.hermes.writer.HLevel;
import org.scharlessantos.hermes.writer.HWriter;

public class FileLogger implements HWriter {

	@Override
	public void logMessage(HLevel level, StackTraceElement source, String message) {
		saveLog(String.format("[S:%-5s] %s.%s(%s:%d)@Thread %d: %s", level.name(), source.getClassName(), source.getMethodName(), source.getFileName(), source.getLineNumber(), Thread.currentThread().getId(), message), null);
	}

	@Override
	public void logException(HLevel level, StackTraceElement source, Throwable exception) {
		saveLog(String.format("[S:%-5s] %s.%s(%s:%d)@Thread %d: Exception", level.name(), source.getClassName(), source.getMethodName(), source.getFileName(), source.getLineNumber(), Thread.currentThread().getId()), exception);
	}

	private DateFormat fileFmt = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat timeFmt = new SimpleDateFormat("HH:mm:ss");
	private PrintWriter wr;
	private String filename = null;

	private synchronized void saveLog(String msg, Throwable exception) {
		try {
			Date now = new Date();
			String name = fileFmt.format(now) + "_srv.log";

			if (wr != null)
				wr.close();

			if (filename == null || !filename.equals(name))
				filename = name;

			File file = new File(new File("log"), filename);

			if (!file.isDirectory()) {
				wr = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
				wr.print(timeFmt.format(now));
				wr.print(" ");
				wr.println(msg);
				if (exception != null)
					exception.printStackTrace(wr);
				wr.flush();

			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
