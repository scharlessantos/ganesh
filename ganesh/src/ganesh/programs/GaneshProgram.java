/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.Ganesh;
import ganesh.common.session.Session;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;

public abstract class GaneshProgram {

	protected static Messages M = Ganesh.getMessages();
	protected static GMessages GM = Ganesh.getGMessages();

	public boolean isMenuAppear(Session session) {
		return true;
	}

	protected abstract String getName();

}
