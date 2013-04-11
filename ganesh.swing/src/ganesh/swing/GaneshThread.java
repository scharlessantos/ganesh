/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing;

import ganesh.common.i18n.GaneshI18n;

public abstract class GaneshThread extends Thread {

	public GaneshThread() {
		setName("Ganesh Thread");
	}

	@Override
	public final void run() {
		GaneshI18n.setLanguage(GaneshSwing.getLanguage());

		realRun();
	}

	protected abstract void realRun();

}
