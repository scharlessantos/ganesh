/* Ganesh Server, developed in 2013*/
package ganesh.embed.http.handlers;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract interface _MyHandler extends Serializable {

	void handle(String target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
