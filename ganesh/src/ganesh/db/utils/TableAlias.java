/* Ganesh Server, developed in 2013*/
package ganesh.db.utils;

import ganesh.db.AbstractDBEntity;

import java.util.HashMap;

public class TableAlias {

	private int count = 0;
	private HashMap<Class<? extends AbstractDBEntity>, String> aliases = new HashMap<>();

	public String newAlias(Class<? extends AbstractDBEntity> cls) {
		if (!aliases.containsKey(cls))
			aliases.put(cls, "t" + (count++));

		return aliases.get(cls);
	}

	public String getAlias(Class<? extends AbstractDBEntity> cls) {
		return aliases.get(cls);
	}
}
