/* Ganesh Commons, developed in 2013 */
package ganesh.common.request;

import ganesh.common.XMLItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestFilter implements XMLItem {

	private HashMap<JoinType, List<RequestFilter>> joins = new HashMap<>();

	private String field = null;
	private Object value = null;
	private FilterType type = null;

	public RequestFilter(String field, Object value, FilterType type) {
		this.field = field;
		this.value = value;
		this.type = type;
	}

	public RequestFilter() {

	}

	public HashMap<JoinType, List<RequestFilter>> getJoins() {
		return new HashMap<>(joins);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public FilterType getType() {
		return type;
	}

	public void setType(FilterType type) {
		this.type = type;
	}

	public void and(RequestFilter query) {
		join(JoinType.AND, query);
	}

	public void or(RequestFilter query) {
		join(JoinType.OR, query);
	}

	protected void join(JoinType j, RequestFilter q) {
		List<RequestFilter> qs = joins.get(j);

		if (qs == null)
			qs = new ArrayList<>();

		if (q != null)
			qs.add(q);

		joins.put(j, qs);
	}

	public enum JoinType {
		AND("and"), OR("or");

		private String join;

		private JoinType(String join) {
			this.join = join;
		}

		public String toJoinText() {
			return join;
		}

		public static JoinType getByType(String type) {
			for (JoinType j: values())
				if (j.join.equals(type))
					return j;

			return null;
		}
	}

	public enum FilterType {
		LIKE(" like "), EQUALS("="), NOT_EQUALS("<>"), GREATER(">"), GREATER_EQUALS(">="), LESS("<"), LESS_EQUALS("<=");

		private String type;

		private FilterType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public static FilterType getByAcronym(String acronym) {
			for (FilterType type: values())
				if (type.type.equals(acronym))
					return type;

			return null;
		}
	}

	@Override
	public String toXML() {
		StringBuilder sb = new StringBuilder();

		sb.append("<filter field='");
		sb.append(field == null ? "" : field);
		sb.append("' value='");
		sb.append(value == null ? "" : value);
		sb.append("' type='");
		sb.append(type == null ? "" : type.getType());

		if (joins.isEmpty()) {
			sb.append("' />");
		} else {
			sb.append("' >\n");

			for (JoinType j: joins.keySet()) {
				if (joins.get(j) == null)
					continue;

				sb.append("<join");
				sb.append(" type='");
				sb.append(j.toJoinText());
				sb.append("' >\n");

				for (RequestFilter f: joins.get(j)) {
					sb.append(f.toXML());
					sb.append("\n");
				}

				sb.append("</join>\n");

			}

			sb.append("</filter>");
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Filter [field=");
		sb.append(field == null ? "" : field);
		sb.append(" value=");
		sb.append(value == null ? "" : value);
		sb.append(" type=");
		sb.append(type == null ? "" : type.getType());

		if (joins.isEmpty()) {
			sb.append("]");
		} else {
			sb.append(" joins={");

			for (JoinType j: joins.keySet()) {
				if (joins.get(j) == null)
					continue;

				sb.append("join [");
				sb.append(" type=");
				sb.append(j.toJoinText());
				sb.append(" filters={");

				for (RequestFilter f: joins.get(j)) {
					sb.append(f.toString());
					sb.append("; ");
				}

				sb.append("]; ");
			}

			sb.append("]");
		}

		return sb.toString();
	}
}
