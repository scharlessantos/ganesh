/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;
import ganesh.db.utils.TableAlias;
import ganesh.embed.database.DBServer;
import ganesh.exception.ServerErrorCode;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.scharlessantos.hermes.Hermes;

public class DB {

	public static <T extends AbstractDBEntity> T first(Class<? extends T> cls, Filter filter) throws GException {
		List<T> list = list(cls, filter);

		if (list == null || list.size() <= 0)
			return null;

		return list.get(0);
	}

	public static <T extends AbstractDBEntity> List<T> list(Class<? extends T> cls) throws GException {
		return list(cls, null);
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractDBEntity> List<T> list(Class<? extends T> cls, Filter filter) throws GException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");

		TableAlias ta = new TableAlias();
		Class<? extends AbstractDBEntity> c = cls;

		boolean first = true;
		while (true) {

			for (Field field: c.getDeclaredFields()) {
				String name = null;
				if (field.isAnnotationPresent(Id.class))
					name = field.getAnnotation(Id.class).value();
				else if (field.isAnnotationPresent(Property.class)) {
					name = field.getAnnotation(Property.class).value();
				}

				if (name != null) {
					if (!first)
						sb.append(", ");
					else
						first = false;

					sb.append(ta.newAlias(c));
					sb.append(".");
					sb.append(name);
				}

			}

			if (c.getSuperclass() == AbstractDBEntity.class)
				break;

			c = (Class<? extends AbstractDBEntity>)c.getSuperclass();
		}

		//From me
		sb.append(" from ");
		sb.append(getEntity(cls));

		if (ta.getAlias(cls) != null) {
			sb.append(" ");
			sb.append(ta.getAlias(cls));
		}

		//Joins

		if (cls.getSuperclass() != AbstractDBEntity.class) {
			c = (Class<? extends AbstractDBEntity>)cls.getSuperclass();
			Class<? extends AbstractDBEntity> below = cls;

			while (true) {

				sb.append(" inner join ");
				sb.append(getEntity(c));
				sb.append(" ");
				sb.append(ta.newAlias(c));
				sb.append(" on (");

				boolean id = false;
				for (Field field: c.getDeclaredFields())
					if (field.isAnnotationPresent(Id.class)) {
						String nome = field.getAnnotation(Id.class).value();

						if (id)
							sb.append(" and ");

						sb.append(ta.getAlias(below));
						sb.append(".");
						sb.append(nome);
						sb.append("=");
						sb.append(ta.getAlias(c));
						sb.append(".");
						sb.append(nome);

						id = true;
					}

				if (!id) {
					Hermes.error(c.getName() + " não possui @Id");
					throw new GException(ServerErrorCode.DB_ERROR);
				}

				sb.append(")");

				if (c.getSuperclass() == AbstractDBEntity.class)
					break;

				below = c;
				c = (Class<? extends AbstractDBEntity>)c.getSuperclass();
			}
		}

		if (filter != null) {
			sb.append(" where ");
			sb.append(filter.genSQL(ta));
		}

		List<T> list = new ArrayList<>();

		ResultSet rs = DBServer.getInstance().executeQuery(sb.toString());

		try {
			while (rs.next()) {
				try {
					T obj = cls.newInstance();

					c = cls;

					int i = 1;
					while (true) {

						for (Field field: c.getDeclaredFields()) {
							boolean sets = false;

							if (field.isAnnotationPresent(Id.class))
								sets = true;

							if (!sets)
								if (field.isAnnotationPresent(Property.class))
									sets = true;

							if (sets) {
								Object value = rs.getObject(i++);
								field.set(obj, value);
							}
						}

						if (c.getSuperclass() == AbstractDBEntity.class)
							break;

						c = (Class<? extends AbstractDBEntity>)c.getSuperclass();
					}

					list.add(obj);

				} catch (InstantiationException | IllegalAccessException e) {
					Hermes.error(e);
				}
			}
		} catch (SQLException e) {
			Hermes.error(e);
			throw new GException(ServerErrorCode.DB_ERROR);
		}

		return list;
	}

	private static String getEntity(Class<? extends AbstractDBEntity> cls) throws GException {
		if (cls.isAnnotationPresent(Entity.class))
			return cls.getAnnotation(Entity.class).value();

		throw new GException(ServerErrorCode.DB_ERROR);
	}

}
