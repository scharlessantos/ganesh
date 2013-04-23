/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing;

import ganesh.common.i18n.GaneshI18n;
import ganesh.common.session.Session;
import ganesh.swing.i18n.I18nListener;
import ganesh.swing.i18n.Messages;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import org.scharlessantos.atlas.Language;

public class GaneshSwing {

	private static Session session;

	private static Language language = null;

	public static Session getSession() {
		return session.copy();
	}

	public static void setSession(Session session) {
		GaneshSwing.session = session;
	}

	public static Language getLanguage() {
		return language;
	}

	public static void setLanguage(Language language) {
		if (language != GaneshSwing.language) {
			GaneshSwing.language = language;
			GaneshI18n.setLanguage(language);

			Messages M = getMessages();

			UIManager.put("OptionPane.yesButtonText", M.sim());
			UIManager.put("OptionPane.cancelButtonText", M.cancelar());
			UIManager.put("OptionPane.noButtonText", M.nao());
			UIManager.put("OptionPane.okButtonText", M.ok());

			List<I18nListener> ls = new ArrayList<>(listeners);

			for (I18nListener l: ls)
				l.onLanguageChanged();

		}
	}

	public static Messages getMessages() {
		return GaneshI18n.genI18nClass(Messages.class);
	}

	private static List<I18nListener> listeners = new ArrayList<>();

	public static void addI18nListerner(I18nListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener))
				listeners.add(listener);
		}

	}
}
