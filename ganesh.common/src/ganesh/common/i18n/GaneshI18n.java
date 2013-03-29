/* Ganesh Commons, developed in 2013 */
package ganesh.common.i18n;

import ganesh.common.session.Session;
import ganesh.common.session.SessionManager;

import java.io.InputStream;

import org.scharlessantos.atlas.Atlas;
import org.scharlessantos.atlas.Language;

/**
 * 
 */
public class GaneshI18n {

	private Atlas translator;
	private static GaneshI18n instance;

	public static GaneshI18n getInstance() {
		if (instance == null)
			instance = new GaneshI18n();

		return instance;
	}

	private GaneshI18n() {
		translator = new Atlas(Language.EN_US);
	}

	protected void _loadTranslations(Language lang, InputStream input) {
		translator.loadTranslations(lang, input);
	}

	protected String _translate(String key, Object... args) {
		Session session = SessionManager.getCurrentSession();
		if (session != null)
			return translator.translate(SessionManager.getCurrentSession().getLanguage(), key, args);

		return translator.translate(null, key, args);
	}

	public static void loadTranslations(Language lang, InputStream input) {
		getInstance()._loadTranslations(lang, input);
	}

	public static String translate(String key) {
		return translate(key, new Object[] {});
	}

	public static String translate(String key, Object... args) {
		return getInstance()._translate(key, args);
	}
}
