/* Ganesh Commons, developed in 2013 */
package ganesh.common.i18n;

import ganesh.common.session.Session;
import ganesh.common.session.SessionManager;

import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyFactory.ClassLoaderProvider;
import javassist.util.proxy.ProxyObject;

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
		translator = new Atlas(Language.PT_BR);
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

	private static HashMap<Class<?>, SoftReference<Object>> cache = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <G> G genI18nClass(final Class<? extends G> intf) {
		ProxyFactory.classLoaderProvider = new ClassLoaderProvider() {

			@Override
			public ClassLoader get(ProxyFactory pf) {
				return intf.getClassLoader();
			}
		};

		SoftReference<Object> instance = cache.get(intf);
		if (instance == null)
			try {
				ProxyFactory f = new ProxyFactory();
				f.setSuperclass(Object.class);
				f.setInterfaces(new Class<?>[] { intf });
				f.setFilter(mf);
				Class<?> c = f.createClass();
				Object obj = c.newInstance();
				((ProxyObject)obj).setHandler(mh);
				instance = new SoftReference<Object>(obj);
				cache.put(intf, instance);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}

		return (G)instance.get();
	}

	private static MethodHandler mh = new MethodHandler() {

		public Object invoke(Object self, Method m, Method proceed, Object[] args) throws Throwable {
			StringBuilder sb = new StringBuilder();
			sb.append(m.getName());
			sb.append('(');
			boolean f = true;
			for (Class<?> t: m.getParameterTypes()) {
				if (!f)
					sb.append(", ");
				sb.append(t.getSimpleName());
				f = false;
			}
			sb.append(")");
			String name = sb.toString();

			if (m.getReturnType().equals(GString.class))
				if (args == null || args.length == 0)
					return new GString(name);
				else
					return new GString(name, args);

			if (m.getReturnType().equals(String.class))
				if (args == null || args.length == 0)
					return GaneshI18n.translate(name);
				else
					return GaneshI18n.translate(name, args);

			throw new RuntimeException("Método precisa retornar String ou GString " + m.getName());
		}
	};

	private static MethodFilter mf = new MethodFilter() {

		public boolean isHandled(Method m) {
			return !m.getDeclaringClass().equals(Object.class);
		}
	};
}
