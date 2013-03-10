/* Ganesh Server, developed in 2013*/
package ganesh.programs;

import ganesh.programs.ProgramManager.RequestType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestHandler {

	/**
	 * Nome da ação a que o método responde
	 */
	RequestType value();

}
