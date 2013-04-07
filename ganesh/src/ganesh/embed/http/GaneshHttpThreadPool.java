/* Ganesh Server, developed in 2013*/
package ganesh.embed.http;

import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class GaneshHttpThreadPool extends QueuedThreadPool {

	public GaneshHttpThreadPool() {
		super();
		setName("Ganesh HTTP Thread");
	}
}
