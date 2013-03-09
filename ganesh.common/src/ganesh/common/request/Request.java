/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.response.Response;
import ganesh.common.session.Session;

import javax.servlet.http.HttpServletRequest;

public class Request {

	public void decode(HttpServletRequest original) {
		//TODO bacalhau
		//		session = new Session(UUID.randomUUID().toString());
		//		session.addProperty("teste", "lalalalalalala");
		//		session.addProperty("test2", "lalalalalalala");
		//		session.addProperty("test3", "lalalalalalala");
	}

	public Response doRequest() {
		return null;
	}

	private Session session;

	public Session getSession() {
		return session;
	}

}
