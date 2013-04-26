/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.main;

import ganesh.swing.GaneshSwing;
import ganesh.swing.GaneshThread;

public class GaneshMain extends GaneshThread {

	@Override
	protected void realRun() {
		GaneshMainFrame main = new GaneshMainFrame();
		GaneshSwing.addI18nListerner(main);

		main.setVisible(true);
	}

}
