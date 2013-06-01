/* Ganesh Server, developed in 2013*/
package ganesh.db.utils;

import ganesh.common.request.RequestFilter.FilterType;
import ganesh.common.request.RequestFilter.JoinType;
import ganesh.db.AbstractDBEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Filter {

	private HashMap<JoinType, List<Filter>> joins = new HashMap<>();

	private String field = null;
	private Object value = null;
	private FilterType type = null;
	private Class<? extends AbstractDBEntity> cls;

	private String sql;

	public Filter(Class<? extends AbstractDBEntity> cls, String field, Object value, FilterType type) {
		this.field = field;
		this.value = value;
		this.type = type;
		this.cls = cls;
	}

	public Filter(String sql) {
		this.sql = sql;
	}

	public Filter() {

	}

	public String genSQL(TableAlias alias) {
		String query = null;

		if (field != null) {
			String aliasField = field;

			if (alias != null) {
				String a = alias.getAlias(cls);

				if (a != null)
					aliasField = a + "." + aliasField;
			}

			if (value == null)
				query = aliasField + " is null";
			else if (value instanceof String && type == FilterType.LIKE)
				query = "upper(" + aliasField + ") like '" + value.toString().toUpperCase() + "'";
			else
				query = aliasField + type.getType() + "'" + value + "'";
		} else if (sql != null)
			query = sql;

		List<Filter> querys = joins.get(JoinType.OR);

		if (querys != null && querys.size() > 0) {

			if (query != null)
				query = "(" + query;

			for (Filter q: querys)
				query += (query == null ? "(" : " or ") + q.genSQL(alias);

			query += ")";

		}

		querys = joins.get(JoinType.AND);

		if (querys != null && querys.size() > 0)
			for (Filter q: querys)
				if (query == null)
					query = q.genSQL(alias);
				else
					query += " and " + q.genSQL(alias);

		return query == null ? "" : query;
	}

	public void and(Filter query) {
		join(JoinType.AND, query);
	}

	public void or(Filter query) {
		join(JoinType.OR, query);
	}

	private void join(JoinType j, Filter q) {
		List<Filter> qs = joins.get(j);

		if (qs == null)
			qs = new ArrayList<>();

		qs.add(q);
		joins.put(j, qs);
	}

}
