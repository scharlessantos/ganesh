/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.Ganesh;
import ganesh.common.XMLItem;
import ganesh.common.exceptions.GException;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;
import ganesh.db.utils.ObjectId;
import ganesh.embed.database.DBServer;
import ganesh.exception.ServerErrorCode;
import ganesh.i18n.Messages;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.scharlessantos.hermes.Hermes;

public abstract class AbstractDBEntity implements XMLItem {

	protected static final Messages M = Ganesh.getMessages();

	@Override
	public String toXML() {
		StringBuilder xml = new StringBuilder();

		if (getClass().isAnnotationPresent(Entity.class)) {
			xml.append("<" + getClass().getAnnotation(Entity.class).value());

			Class<?> cls = getClass();

			while (cls != AbstractDBEntity.class) {
				for (Field f: cls.getDeclaredFields())
					try {
						if (f.isAnnotationPresent(Id.class)) {
							xml.append(" ");
							xml.append(f.getAnnotation(Id.class).value());
							xml.append("='");

							xml.append(f.get(this));

							xml.append("'");
						} else if (f.isAnnotationPresent(Property.class)) {
							xml.append(" ");
							xml.append(f.getAnnotation(Property.class).value());
							xml.append("='");
							xml.append(f.get(this));
							xml.append("'");
						}

					} catch (IllegalArgumentException | IllegalAccessException e) {
						Hermes.error(e);
					}

				cls = cls.getSuperclass();
			}

			xml.append(" />");
		}
		return xml.toString();
	}

	/**
	 * @throws GException
	 */
	public synchronized void save() throws GException {
		if (getClass().getSuperclass() != AbstractDBEntity.class) {
			Class<?> cls = getClass().getSuperclass();

			try {

				AbstractDBEntity i = (AbstractDBEntity)cls.getConstructor(cls).newInstance(cls.cast(this));
				i.save();
				this.merge(i);
				i = null;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				Hermes.error(cls.getName() + " não possui construtor de si mesmo!");
				throw new GException(ServerErrorCode.DB_UPDATE, M.erroAoSalvar());
			}

		}

		String entity = null;

		if (getClass().isAnnotationPresent(Entity.class))
			entity = getClass().getAnnotation(Entity.class).value();

		if (entity == null)
			throw new GException(ServerErrorCode.DB_ERROR, M.erroAoSalvar());

		Filter id = new Filter();

		try {

			for (Field f: getClass().getDeclaredFields())
				if (f.isAnnotationPresent(Id.class))
					id.and(new Filter(getClass(), f.getAnnotation(Id.class).value(), f.get(this), FilterType.EQUALS));

		} catch (IllegalArgumentException | IllegalAccessException e) {
			Hermes.error(e);
			throw new GException(ServerErrorCode.DB_UPDATE, M.erroAoSalvar());
		}

		AbstractDBEntity e = DB.first(getClass(), id);

		StringBuilder sql = new StringBuilder();

		if (e == null) { //Inserir um novo registro
			StringBuilder values = new StringBuilder();

			sql.append("insert into ");
			sql.append(entity);
			sql.append(" (");

			List<Field> fields = new ArrayList<>();
			fields.addAll(Arrays.asList(getClass().getDeclaredFields()));

			Class<?> c = getClass().getSuperclass();

			while (c != AbstractDBEntity.class) {
				for (Field f: c.getDeclaredFields())
					if (f.isAnnotationPresent(Id.class))
						fields.add(f);

				c = c.getSuperclass();
			}

			boolean first = true;
			for (Field field: fields) {

				String f = null;
				Object v = null;

				if (field.isAnnotationPresent(Id.class))
					try {
						v = field.get(this);
						f = field.getAnnotation(Id.class).value();

						if (v == null) {
							v = new ObjectId().get();
							field.set(this, v);
						}

					} catch (IllegalArgumentException | IllegalAccessException e1) {
						Hermes.error(e1);
					}
				else if (field.isAnnotationPresent(Property.class))
					try {
						v = field.get(this);
						f = field.getAnnotation(Property.class).value();
					} catch (IllegalArgumentException | IllegalAccessException e1) {
						Hermes.error(e1);
					}

				if (f != null)
					if (!first) {
						sql.append(", ");
						values.append(", ");
					} else
						first = false;

				sql.append(f);

				if (v == null)
					values.append("null");
				else {
					values.append("'");
					values.append(v.toString());
					values.append("'");
				}

			}

			sql.append(" ) values (");
			sql.append(values);
			sql.append(")");

		} else {
			//update
			sql.append("update ");
			sql.append(entity);
			sql.append(" set ");

			boolean first = true;
			for (Field f: getClass().getDeclaredFields()) {
				if (f.isAnnotationPresent(Property.class)) {
					try {
						Object value = f.get(this);

						if (!first)
							sql.append(", ");
						else
							first = false;

						sql.append(f.getAnnotation(Property.class).value());
						sql.append("='");
						sql.append(value);
						sql.append("' ");
					} catch (IllegalArgumentException | IllegalAccessException e1) {
						Hermes.error(e1);
					}
				}
			}

			sql.append(" where ");
			sql.append(id.genSQL(null));
		}

		DBServer.getInstance().executeUpdate(sql.toString());
	}

	protected abstract void merge(AbstractDBEntity other);

	@SuppressWarnings("unchecked")
	public void delete() throws GException {
		StringBuilder sql = new StringBuilder();
		sql.append(genDeleteSQL(getClass()));

		Class<?> cls = getClass().getSuperclass();

		while (!cls.equals(AbstractDBEntity.class)) {
			sql.append("; ");
			sql.append(genDeleteSQL((Class<? extends AbstractDBEntity>)cls));
		}

		DBServer.getInstance().executeUpdate(sql.toString());

	}

	protected String genDeleteSQL(Class<? extends AbstractDBEntity> cls) throws GException {
		StringBuilder sb = new StringBuilder();

		String entity = null;

		if (cls.isAnnotationPresent(Entity.class))
			entity = cls.getAnnotation(Entity.class).value();

		if (entity == null)
			throw new GException(ServerErrorCode.DB_ERROR, M.erroAoApagar());

		sb.append("delete from ");
		sb.append(entity);
		sb.append(" where ");

		Filter id = new Filter();

		for (Field f: cls.getDeclaredFields())
			if (f.isAnnotationPresent(Id.class))
				try {
					id.and(new Filter(getClass(), f.getAnnotation(Id.class).value(), f.get(this), FilterType.EQUALS));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					Hermes.error(e);
					throw new GException(ServerErrorCode.DB_ERROR, e);
				}

		sb.append(id.genSQL(null));

		return sb.toString();
	}
}
