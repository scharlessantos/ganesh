/* Ganesh Server, developed in 2013*/
package ganesh.access;

import ganesh.common.session.Session;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.Hermes;

public class AccessControl {

	//=+=+=+=+=+=+=+=+=++=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
	//		Controle de Acesso Chuck Noris: 
	//			   só pode existir um
	//=+=+=+=+=+=+=+=+=++=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
	private static AccessControl instance;

	public static AccessControl getInstance() {
		if (instance == null)
			instance = new AccessControl();

		return instance;
	}

	private AccessControl() {
		new TimeoutSession().start();
	}

	//=+=+=+=+=+=+=+=+=++=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=

	private HashMap<Session, Long> sessions = new HashMap<>();

	public Session newSession(Language lang) {
		String uuid = UUID.randomUUID().toString();
		Session session = new Session(uuid, lang);

		synchronized (sessions) {
			sessions.put(session, System.currentTimeMillis());
		}

		Hermes.info("New session: " + uuid);

		return session;
	}

	public Session getSession(String uuid) {
		synchronized (sessions) {
			for (Session session: sessions.keySet())
				if (session.getUuid().equals(uuid))
					return session;

		}

		return null;
	}

	public void updateSession(Session session) {
		synchronized (sessions) {
			Session s = getSession(session.getUuid());

			if (s == null)
				sessions.put(session, System.currentTimeMillis());
			else
				s.update(session);
		}
	}

	public void invalidateSession(String uuid) {
		synchronized (sessions) {
			for (Session session: sessions.keySet())
				if (session.getUuid().equals(uuid))
					sessions.remove(session);
		}
	}

	public void invalidateSession(Session session) {
		synchronized (sessions) {
			if (sessions.containsKey(session))
				sessions.remove(session);
		}
	}

	private static class TimeoutSession extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (AccessControl.instance.sessions) {
					for (Entry<Session, Long> session: AccessControl.instance.sessions.entrySet())
						if (session.getValue() < System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(20))
							AccessControl.instance.sessions.remove(session);

				}

				try {
					sleep(TimeUnit.SECONDS.toMillis(5));
				} catch (InterruptedException e) {
					Hermes.error(e);
					break;
				}
			}
		}
	}
}
