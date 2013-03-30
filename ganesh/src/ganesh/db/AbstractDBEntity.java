/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.Ganesh;
import ganesh.common.exceptions.ErrorCode;
import ganesh.common.exceptions.GException;
import ganesh.common.response.ResponseItem;
import ganesh.embed.database.DBServer;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import org.scharlessantos.hermes.Hermes;

public abstract class AbstractDBEntity implements ResponseItem {

	protected final Messages M = Ganesh.getMessages();
	protected final GMessages GM = Ganesh.getGMessages();

	@Override
	public String toXML() {
		StringBuilder xml = new StringBuilder();

		xml.append("<" + getClass().getSimpleName().toLowerCase());

		for (Method method: getClass().getMethods())
			if (method.isAnnotationPresent(_DBField.class)) {
				try {
					Object r = method.invoke(this);
					xml.append(" ");
					xml.append(method.getAnnotation(_DBField.class).value());
					xml.append("='");
					xml.append(r == null ? "" : r.toString());
					xml.append("'");
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Hermes.error(e);
				}
			}

		xml.append(" />");
		return xml.toString();
	}

	public void save() throws GException {
		StringBuilder sql = new StringBuilder();
		StringBuilder values = new StringBuilder();

		sql.append("insert into ");
		sql.append(getClass().getSimpleName().toUpperCase());
		sql.append(" (");

		boolean first = true;
		for (Method method: getClass().getMethods())
			if (method.isAnnotationPresent(_DBField.class)) {
				try {
					Object r = method.invoke(this);

					if (!first) {
						sql.append(", ");
						values.append(", ");
					} else
						first = false;

					sql.append(method.getAnnotation(_DBField.class).value());

					if (r == null)
						values.append("null");
					else {
						values.append("'");
						values.append(r.toString());
						values.append("'");
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					Hermes.error(e);
					throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_(getClass().getSimpleName()));
				}
			}

		sql.append(" ) values (");
		sql.append(values);
		sql.append(")");

		Connection conn = DBServer.getInstance().getConnection();

		if (conn == null)
			throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_(getClass().getSimpleName()));

		try {
			conn.createStatement().executeUpdate(sql.toString());
		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ErrorCode.DB_ERROR, M.erroAoInserir_(getClass().getSimpleName()));
		}
	}
}
