/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.handlers;

import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class _DebugHandler implements _MyHandler {

	private static final long serialVersionUID = 3726373459685376961L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh Debug Thread");

		resp.setContentType("text/html");
		genHtml(resp.getWriter());
		resp.getWriter().println(_InfoHandler.poweredBy());
	}

	private static void genHtml(Writer writer) throws IOException {
		HtmlWriter wr = new HtmlWriter(writer);

		Map<Thread, StackTraceElement[]> stacks = Thread.getAllStackTraces();
		List<Thread> threads = new ArrayList<Thread>(stacks.keySet());
		Collections.sort(threads, new Comparator<Thread>() {

			@Override
			public int compare(Thread t1, Thread t2) {
				return Long.valueOf(t1.getId()).compareTo(t2.getId());
			}
		});

		// Get current size of heap in bytes
		long heapSize = Runtime.getRuntime().totalMemory();

		// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
		// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory();

		// Get amount of free memory within the heap in bytes. This size will increase
		// after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory();

		wr.println("<html>");
		wr.println("<head>");
		wr.println("<title>Server Debug Info</title>");
		wr.println("<style type='text/css'>table{border-collapse:collapse;}table, td, th{border:1px solid black;}</style>");
		wr.println("</head>");
		wr.println("<body>");
		wr.println("<h1><a name='inicio'>Ganesh Server Debug Info</a></h1>");

		wr.println(new Timestamp(System.currentTimeMillis()).toString());

		wr.println("<h2>Heap Space</h2>");
		wr.println("<b>Max:</b> %s<br/>", formatByteSize(heapMaxSize));
		wr.println("<b>Allocated:</b> %s<br/>", formatByteSize(heapSize));
		wr.println("<b>Used:</b> %s<br/>", formatByteSize(heapSize - heapFreeSize));
		wr.println("<b>Free:</b> %s<br/>", formatByteSize(heapFreeSize));

		wr.println("<h2>Threads</h2>");
		wr.println("<table>");
		wr.println("<tr><th colspan='2'>Thread</th><th>Status</th><th>Daemon</th><th>Priority</th></tr>");
		for (Thread thread: threads) {
			wr.println("<tr><td><a href='#thread_%d'>%d</a></td><td><a href='#thread_%d'>%s</a></td><td>%s</td><td>%s</td><td>%d</td></tr>", thread.getId(), thread.getId(), thread.getId(), thread.getName(), thread.getState(), thread.isDaemon() ? "Daemon" : "User", thread.getPriority());
		}
		wr.println("</table>");

		wr.println("</table>");

		//== Threads
		for (Thread thread: threads) {
			wr.println("<h3><a name='thread_%d'>Thread %d: %s</a> (%s)</h3>", thread.getId(), thread.getId(), thread.getName(), thread.getState());
			wr.println("<b>Daemon:</b> %s<br/>", thread.isDaemon() ? "Yes" : "No");
			wr.println("<b>Priority:</b> %d<br/>", thread.getPriority());

			wr.println("<pre>");
			StackTraceElement[] stackTrace = stacks.get(thread);
			for (StackTraceElement elem: stackTrace) {
				wr.println(elem.toString());
			}
			wr.println("</pre>");
			wr.println("<a href='#inicio'>Inicio</a><hr/>");
		}

		wr.println("</body>");
		wr.print("</html>");
	}

	private static final int KB = 1024;
	private static final int MB = 1024 * KB;

	private static String formatByteSize(long size) {
		double d = (double)size;
		if (size > MB)
			return String.format("%.03f MB", (d / MB));
		if (size > KB)
			return String.format("%.03f KB", (d / KB));
		return String.format("%d B", size);
	}

	private static class HtmlWriter {

		private Writer wr;

		public HtmlWriter(Writer wr) {
			this.wr = wr;
		}

		public void println(String str) throws IOException {
			wr.write(str);
			wr.write('\n');
		}

		public void println(String format, Object... args) throws IOException {
			wr.write(String.format(format, args));
			wr.write('\n');
		}

		public void print(String str) throws IOException {
			wr.write(str);
		}
	}

}
