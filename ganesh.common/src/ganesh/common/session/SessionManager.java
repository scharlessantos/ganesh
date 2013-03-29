/* Ganesh Commons, developed in 2013 */
package ganesh.common.session;

import java.util.WeakHashMap;

public class SessionManager {

	private static WeakHashMap<Thread, Session> sessions = new WeakHashMap<>();

	public static Session getCurrentSession() {
		synchronized (sessions) {
			Thread current = Thread.currentThread();
			if (sessions.get(current) != null)
				return sessions.get(current);
		}

		return null;
	}

	public static void setSession(Session session) {
		synchronized (sessions) {
			Thread current = Thread.currentThread();

			sessions.remove(current);
			sessions.put(current, session);
		}
	}

	public static void removeSession(Session session) {
		synchronized (sessions) {
			Thread current = Thread.currentThread();
			sessions.remove(current);
		}
	}
}
