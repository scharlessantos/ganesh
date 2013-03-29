/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.response.ResponseItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.scharlessantos.hermes.Hermes;

public abstract class AbstractDBEntity implements ResponseItem {

	@Override
	public String toXML() {
		String xml = "<" + getClass().getSimpleName().toLowerCase();

		for (Method method: getClass().getMethods())
			if (method.isAnnotationPresent(_DBField.class)) {
				try {
					Object r = method.invoke(this);
					xml += " " + method.getAnnotation(_DBField.class).value() + "='" + (r == null ? "" : r.toString()) + "'";
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Hermes.error(e);
				}
			}

		return xml + " />";
	}

}
