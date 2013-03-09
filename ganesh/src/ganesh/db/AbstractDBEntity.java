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
			if (method.isAnnotationPresent(_XMLEntity.class)) {
				try {
					xml += " " + method.getAnnotation(_XMLEntity.class).value() + "='" + (method.invoke(this)) + "'";
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Hermes.error(e);
				}
			}

		return xml + " />";
	}

}
