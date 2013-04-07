// ========================================================================
// Copyright (c) 2004-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package org.eclipse.jetty.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* ------------------------------------------------------------ */
/**
 * Configure Objects from XML. This class reads an XML file conforming to the configure.dtd DTD and uses it to configure and object by calling set, put or other methods on the object.
 * <p>
 * The actual XML file format may be changed (eg to spring XML) by implementing the {@link ConfigurationProcessorFactory} interfaces to be found by the <code>ServiceLoader</code> by using the DTD and first tag element in the file. Note that DTD will be null if validation is off.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class XmlConfiguration
{

	private static final Logger LOG = Log.getLogger(XmlConfiguration.class);

	private static final Class<?>[] __primitives =
	{ Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE };

	private static final Class<?>[] __primitiveHolders =
	{ Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class };
	private static final Integer ZERO = new Integer(0);

	private static final Iterable<?> __factoryLoader;
	static
	{
		Iterable<?> loader = null;
		try
		{
			// Use reflection to look up 1.6 service loader
			// loader=ServiceLoader.load(ConfigurationProcessorFactory.class); 
			Class<?> slc = ClassLoader.getSystemClassLoader().loadClass("java.util.ServiceLoader");
			Method load = slc.getMethod("load", Class.class);
			loader = (Iterable<?>)load.invoke(null, ConfigurationProcessorFactory.class);
		} catch (Exception e)
		{
			LOG.ignore(e);
		} finally
		{
			__factoryLoader = loader;
		}
	}

	/* ------------------------------------------------------------ */
	private static XmlParser __parser;
	private URL _url;
	private XmlParser.Node _config;
	private String _dtd;
	private ConfigurationProcessor _processor;
	private final Map<String, Object> _idMap = new HashMap<String, Object>();
	private final Map<String, String> _propertyMap = new HashMap<String, String>();

	/* ------------------------------------------------------------ */
	private synchronized static void initParser() throws IOException
	{
		if (__parser != null)
			return;

		__parser = new XmlParser();
		try
		{
			URL configURL = Loader.getResource(XmlConfiguration.class, "org/eclipse/jetty/xml/configure_6_0.dtd", true);
			__parser.redirectEntity("configure.dtd", configURL);
			__parser.redirectEntity("configure_1_0.dtd", configURL);
			__parser.redirectEntity("configure_1_1.dtd", configURL);
			__parser.redirectEntity("configure_1_2.dtd", configURL);
			__parser.redirectEntity("configure_1_3.dtd", configURL);
			__parser.redirectEntity("configure_6_0.dtd", configURL);

			__parser.redirectEntity("http://jetty.mortbay.org/configure.dtd", configURL);
			__parser.redirectEntity("http://jetty.eclipse.org/configure.dtd", configURL);
			__parser.redirectEntity("http://www.eclipse.org/jetty/configure.dtd", configURL);

			__parser.redirectEntity("-//Mort Bay Consulting//DTD Configure//EN", configURL);
			__parser.redirectEntity("-//Jetty//Configure//EN", configURL);
		} catch (ClassNotFoundException e)
		{
			LOG.warn(e.toString());
			LOG.debug(e);
		}
	}

	/* ------------------------------------------------------------ */
	/**
	 * Constructor. Reads the XML configuration file.
	 * 
	 * @param configuration
	 */
	public XmlConfiguration(URL configuration) throws SAXException, IOException
	{
		initParser();
		synchronized (__parser)
		{
			_url = configuration;
			setConfig(__parser.parse(configuration.toString()));
			_dtd = __parser.getDTD();
		}
	}

	/* ------------------------------------------------------------ */
	/**
	 * Constructor.
	 * 
	 * @param configuration String of XML configuration commands excluding the normal XML preamble. The String should start with a " <Configure ...." element.
	 * @exception SAXException
	 * @exception IOException
	 */
	public XmlConfiguration(String configuration) throws SAXException, IOException
	{
		initParser();
		configuration = "<?xml version=\"1.0\"  encoding=\"ISO-8859-1\"?>\n<!DOCTYPE Configure PUBLIC \"-//Mort Bay Consulting//DTD Configure 1.2//EN\" \"http://jetty.eclipse.org/configure_1_2.dtd\">"
			+ configuration;
		InputSource source = new InputSource(new StringReader(configuration));
		synchronized (__parser)
		{
			setConfig(__parser.parse(source));
			_dtd = __parser.getDTD();
		}
	}

	/* ------------------------------------------------------------ */
	/**
	 * Constructor.
	 * 
	 * @param configuration An input stream containing a complete e.g. configuration file
	 * @exception SAXException
	 * @exception IOException
	 */
	public XmlConfiguration(InputStream configuration) throws SAXException, IOException
	{
		initParser();
		InputSource source = new InputSource(configuration);
		synchronized (__parser)
		{
			setConfig(__parser.parse(source));
			_dtd = __parser.getDTD();
		}
	}

	/* ------------------------------------------------------------ */
	private void setConfig(XmlParser.Node config)
	{
		_config = config;
		if ("Configure".equals(config.getTag()))
		{
			_processor = new JettyXmlConfiguration();
		}
		else if (__factoryLoader != null)
		{
			for (Object factory: __factoryLoader)
			{
				// use reflection to get 1.6 methods
				Method gcp;
				try
				{
					gcp = factory.getClass().getMethod("getConfigurationProcessor", String.class, String.class);
					_processor = (ConfigurationProcessor)gcp.invoke(factory, _dtd, config.getTag());
				} catch (Exception e)
				{
					LOG.warn(e);
				}
				if (_processor != null)
					break;
			}

			if (_processor == null)
				throw new IllegalStateException("Unknown configuration type: " + config.getTag() + " in " + this);
		}
		else
		{
			throw new IllegalArgumentException("Unknown XML tag:" + config.getTag());
		}
		_processor.init(_url, _config, _idMap, _propertyMap);
	}

	/* ------------------------------------------------------------ */
	public Map<String, Object> getIdMap()
	{
		return _idMap;
	}

	/* ------------------------------------------------------------ */
	/**
	 * @deprecated use {@link #getIdMap()}.put(...)
	 */
	@Deprecated
	public void setIdMap(Map<String, Object> map)
	{
		_idMap.clear();
		_idMap.putAll(map);
	}

	/* ------------------------------------------------------------ */
	/**
	 * @deprecated use {@link #getProperties()}.putAll(...)
	 */
	@Deprecated
	public void setProperties(Map<String, String> map)
	{
		_propertyMap.clear();
		_propertyMap.putAll(map);
	}

	/* ------------------------------------------------------------ */
	public Map<String, String> getProperties()
	{
		return _propertyMap;
	}

	/* ------------------------------------------------------------ */
	/**
	 * Configure an object.
	 * <p>
	 * Apply the XML configuration script to the passed object.
	 * </p>
	 * 
	 * @param obj The object to be configured, which must be of a type or super type of the class attribute of the Configure element.
	 * @exception Exception
	 */
	public Object configure(Object obj) throws Exception
	{
		return _processor.configure(obj);
	}

	/* ------------------------------------------------------------ */
	/**
	 * Configure an object. If the configuration has an ID, an object is looked up by ID and it's type check. Otherwise a new object is created.
	 * 
	 * @return The newly created configured object.
	 * @exception Exception
	 */
	public Object configure() throws Exception
	{
		return _processor.configure();
	}

	/* ------------------------------------------------------------ */
	/* ------------------------------------------------------------ */
	/* ------------------------------------------------------------ */
	private static class JettyXmlConfiguration implements ConfigurationProcessor
	{

		XmlParser.Node _config;
		Map<String, Object> _idMap;
		Map<String, String> _propertyMap;

		public void init(URL url, XmlParser.Node config, Map<String, Object> idMap, Map<String, String> properties)
		{
			_config = config;
			_idMap = idMap;
			_propertyMap = properties;
		}

		/* ------------------------------------------------------------ */
		public Object configure(Object obj) throws Exception
		{
			// Check the class of the object
			Class<?> oClass = (Class<?>)nodeClass(_config);
			if (oClass != null && !oClass.isInstance(obj))
			{
				String loaders = (oClass.getClassLoader() == obj.getClass().getClassLoader()) ? "" : "Object Class and type Class are from different loaders.";
				throw new IllegalArgumentException("Object of class '" + obj.getClass().getCanonicalName() + "' is not of type '" + oClass.getCanonicalName() + "'. " + loaders);
			}
			configure(obj, _config, 0);
			return obj;
		}

		/* ------------------------------------------------------------ */
		public Object configure() throws Exception
		{
			Class<?> oClass = (Class<?>)nodeClass(_config);

			String id = _config.getAttribute("id");
			Object obj = id == null ? null : _idMap.get(id);

			if (obj == null && oClass != null)
				obj = oClass.newInstance();

			if (oClass != null && !oClass.isInstance(obj))
				throw new ClassCastException(oClass.toString());

			configure(obj, _config, 0);
			return obj;
		}

		/* ------------------------------------------------------------ */
		private Class<?> nodeClass(XmlParser.Node node) throws ClassNotFoundException
		{
			String className = node.getAttribute("class");
			if (className == null)
				return null;

			return Loader.loadClass(XmlConfiguration.class, className, true);
		}

		/* ------------------------------------------------------------ */
		/**
		 * Recursive configuration step. This method applies the remaining Set, Put and Call elements to the current object.
		 * 
		 * @param obj
		 * @param cfg
		 * @param i
		 * @exception Exception
		 */
		public void configure(Object obj, XmlParser.Node cfg, int i) throws Exception
		{
			String id = cfg.getAttribute("id");
			if (id != null)
				_idMap.put(id, obj);

			for (; i < cfg.size(); i++)
			{
				Object o = cfg.get(i);
				if (o instanceof String)
					continue;
				XmlParser.Node node = (XmlParser.Node)o;

				try
				{
					String tag = node.getTag();
					if ("Set".equals(tag))
						set(obj, node);
					else if ("Put".equals(tag))
						put(obj, node);
					else if ("Call".equals(tag))
						call(obj, node);
					else if ("Get".equals(tag))
						get(obj, node);
					else if ("New".equals(tag))
						newObj(obj, node);
					else if ("Array".equals(tag))
						newArray(obj, node);
					else if ("Ref".equals(tag))
						refObj(obj, node);
					else if ("Property".equals(tag))
						propertyObj(obj, node);
					else
						throw new IllegalStateException("Unknown tag: " + tag);
				} catch (Exception e)
				{
					LOG.warn("Config error at " + node, e.toString());
					throw e;
				}
			}
		}

		/* ------------------------------------------------------------ */
		/*
		 * Call a set method. This method makes a best effort to find a matching set method. The type of the value is used to find a suitable set method by 1.
		 * Trying for a trivial type match. 2. Looking for a native type match. 3. Trying all correctly named methods for an auto conversion. 4. Attempting to
		 * construct a suitable value from original value. @param obj
		 * 
		 * @param node
		 */
		@SuppressWarnings("null")
		private void set(Object obj, XmlParser.Node node) throws Exception
		{
			String attr = node.getAttribute("name");
			String name = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1);
			Object value = value(obj, node);
			Object[] arg =
			{ value };

			Class oClass = nodeClass(node);
			if (oClass != null)
				obj = null;
			else
				oClass = obj.getClass();

			Class[] vClass =
			{ Object.class };
			if (value != null)
				vClass[0] = value.getClass();

			if (LOG.isDebugEnabled())
				LOG.debug("XML " + (obj != null ? obj.toString() : oClass.getName()) + "." + name + "(" + value + ")");

			// Try for trivial match
			try
			{
				Method set = oClass.getMethod(name, vClass);
				set.invoke(obj, arg);
				return;
			} catch (IllegalArgumentException e)
			{
				LOG.ignore(e);
			} catch (IllegalAccessException e)
			{
				LOG.ignore(e);
			} catch (NoSuchMethodException e)
			{
				LOG.ignore(e);
			}

			// Try for native match
			try
			{
				Field type = vClass[0].getField("TYPE");
				vClass[0] = (Class)type.get(null);
				Method set = oClass.getMethod(name, vClass);
				set.invoke(obj, arg);
				return;
			} catch (NoSuchFieldException e)
			{
				LOG.ignore(e);
			} catch (IllegalArgumentException e)
			{
				LOG.ignore(e);
			} catch (IllegalAccessException e)
			{
				LOG.ignore(e);
			} catch (NoSuchMethodException e)
			{
				LOG.ignore(e);
			}

			// Try a field
			try
			{
				Field field = oClass.getField(attr);
				if (Modifier.isPublic(field.getModifiers()))
				{
					field.set(obj, value);
					return;
				}
			} catch (NoSuchFieldException e)
			{
				LOG.ignore(e);
			}

			// Search for a match by trying all the set methods
			Method[] sets = oClass.getMethods();
			Method set = null;
			for (int s = 0; sets != null && s < sets.length; s++)
			{

				Class<?>[] paramTypes = sets[s].getParameterTypes();
				if (name.equals(sets[s].getName()) && paramTypes.length == 1)
				{

					// lets try it
					try
					{
						set = sets[s];
						sets[s].invoke(obj, arg);
						return;
					} catch (IllegalArgumentException e)
					{
						LOG.ignore(e);
					} catch (IllegalAccessException e)
					{
						LOG.ignore(e);
					}

					// Can we convert to a collection
					if (paramTypes[0].isAssignableFrom(Collection.class) && value.getClass().isArray())
					{
						try
						{
							if (paramTypes[0].isAssignableFrom(Set.class))
								sets[s].invoke(obj, new Object[]
								{ new HashSet<Object>(Arrays.asList((Object[])value)) });
							else
								sets[s].invoke(obj, new Object[]
								{ Arrays.asList((Object[])value) });
							return;
						} catch (IllegalArgumentException e)
						{
							LOG.ignore(e);
						} catch (IllegalAccessException e)
						{
							LOG.ignore(e);
						}
					}
				}
			}

			// Try converting the arg to the last set found.
			if (set != null)
			{
				try
				{
					Class sClass = set.getParameterTypes()[0];
					if (sClass.isPrimitive())
					{
						for (int t = 0; t < __primitives.length; t++)
						{
							if (sClass.equals(__primitives[t]))
							{
								sClass = __primitiveHolders[t];
								break;
							}
						}
					}
					Constructor cons = sClass.getConstructor(vClass);
					arg[0] = cons.newInstance(arg);
					set.invoke(obj, arg);
					return;
				} catch (NoSuchMethodException e)
				{
					LOG.ignore(e);
				} catch (IllegalAccessException e)
				{
					LOG.ignore(e);
				} catch (InstantiationException e)
				{
					LOG.ignore(e);
				}
			}

			// No Joy
			throw new NoSuchMethodException(oClass + "." + name + "(" + vClass[0] + ")");
		}

		/* ------------------------------------------------------------ */
		/*
		 * Call a put method.
		 * 
		 * @param obj @param node
		 */
		private void put(Object obj, XmlParser.Node node) throws Exception
		{
			if (!(obj instanceof Map))
				throw new IllegalArgumentException("Object for put is not a Map: " + obj);
			Map<Object, Object> map = (Map<Object, Object>)obj;

			String name = node.getAttribute("name");
			Object value = value(obj, node);
			map.put(name, value);
			if (LOG.isDebugEnabled())
				LOG.debug("XML " + obj + ".put(" + name + "," + value + ")");
		}

		/* ------------------------------------------------------------ */
		/*
		 * Call a get method. Any object returned from the call is passed to the configure method to consume the remaining elements. @param obj @param node
		 * 
		 * @return @exception Exception
		 */
		private Object get(Object obj, XmlParser.Node node) throws Exception
		{
			Class oClass = nodeClass(node);
			if (oClass != null)
				obj = null;
			else
				oClass = obj.getClass();

			String name = node.getAttribute("name");
			String id = node.getAttribute("id");
			if (LOG.isDebugEnabled())
				LOG.debug("XML get " + name);

			try
			{
				// try calling a getXxx method.
				Method method = oClass.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1), (java.lang.Class[])null);
				obj = method.invoke(obj, (java.lang.Object[])null);
				configure(obj, node, 0);
			} catch (NoSuchMethodException nsme)
			{
				try
				{
					Field field = oClass.getField(name);
					obj = field.get(obj);
					configure(obj, node, 0);
				} catch (NoSuchFieldException nsfe)
				{
					throw nsme;
				}
			}
			if (id != null)
				_idMap.put(id, obj);
			return obj;
		}

		/* ------------------------------------------------------------ */
		/*
		 * Call a method. A method is selected by trying all methods with matching names and number of arguments. Any object returned from the call is passed to
		 * the configure method to consume the remaining elements. Note that if this is a static call we consider only methods declared directly in the given
		 * class. i.e. we ignore any static methods in superclasses. @param obj
		 * 
		 * @param node @return @exception Exception
		 */
		private Object call(Object obj, XmlParser.Node node) throws Exception
		{
			String id = node.getAttribute("id");
			Class oClass = nodeClass(node);
			if (oClass != null)
				obj = null;
			else if (obj != null)
				oClass = obj.getClass();
			if (oClass == null)
				throw new IllegalArgumentException(node.toString());

			int size = 0;
			int argi = node.size();
			for (int i = 0; i < node.size(); i++)
			{
				Object o = node.get(i);
				if (o instanceof String)
					continue;
				if (!((XmlParser.Node)o).getTag().equals("Arg"))
				{
					argi = i;
					break;
				}
				size++;
			}

			Object[] arg = new Object[size];
			for (int i = 0, j = 0; j < size; i++)
			{
				Object o = node.get(i);
				if (o instanceof String)
					continue;
				arg[j++] = value(obj, (XmlParser.Node)o);
			}

			String method = node.getAttribute("name");
			if (LOG.isDebugEnabled())
				LOG.debug("XML call " + method);

			try
			{
				Object n = TypeUtil.call(oClass, method, obj, arg);
				if (id != null)
					_idMap.put(id, n);
				configure(n, node, argi);
				return n;
			} catch (NoSuchMethodException e)
			{
				IllegalStateException ise = new IllegalStateException("No Method: " + node + " on " + oClass);
				ise.initCause(e);
				throw ise;
			}

		}

		/* ------------------------------------------------------------ */
		/*
		 * Create a new value object.
		 * 
		 * @param obj @param node @return @exception Exception
		 */
		private Object newObj(Object obj, XmlParser.Node node) throws Exception
		{
			Class oClass = nodeClass(node);
			String id = node.getAttribute("id");
			int size = 0;
			int argi = node.size();
			for (int i = 0; i < node.size(); i++)
			{
				Object o = node.get(i);
				if (o instanceof String)
					continue;
				if (!((XmlParser.Node)o).getTag().equals("Arg"))
				{
					argi = i;
					break;
				}
				size++;
			}

			Object[] arg = new Object[size];
			for (int i = 0, j = 0; j < size; i++)
			{
				Object o = node.get(i);
				if (o instanceof String)
					continue;
				arg[j++] = value(obj, (XmlParser.Node)o);
			}

			if (LOG.isDebugEnabled())
				LOG.debug("XML new " + oClass);

			// Lets just try all constructors for now
			Constructor[] constructors = oClass.getConstructors();
			for (int c = 0; constructors != null && c < constructors.length; c++)
			{
				if (constructors[c].getParameterTypes().length != size)
					continue;

				Object n = null;
				boolean called = false;
				try
				{
					n = constructors[c].newInstance(arg);
					called = true;
				} catch (IllegalAccessException e)
				{
					LOG.ignore(e);
				} catch (InstantiationException e)
				{
					LOG.ignore(e);
				} catch (IllegalArgumentException e)
				{
					LOG.ignore(e);
				}
				if (called)
				{
					if (id != null)
						_idMap.put(id, n);
					configure(n, node, argi);
					return n;
				}
			}

			throw new IllegalStateException("No Constructor: " + node + " on " + obj);
		}

		/* ------------------------------------------------------------ */
		/*
		 * Reference an id value object.
		 * 
		 * @param obj @param node @return @exception NoSuchMethodException @exception ClassNotFoundException @exception InvocationTargetException
		 */
		private Object refObj(Object obj, XmlParser.Node node) throws Exception
		{
			String id = node.getAttribute("id");
			obj = _idMap.get(id);
			if (obj == null)
				throw new IllegalStateException("No object for id=" + id);
			configure(obj, node, 0);
			return obj;
		}

		/* ------------------------------------------------------------ */
		/*
		 * Create a new array object.
		 */
		private Object newArray(Object obj, XmlParser.Node node) throws Exception
		{

			// Get the type
			Class aClass = java.lang.Object.class;
			String type = node.getAttribute("type");
			final String id = node.getAttribute("id");
			if (type != null)
			{
				aClass = TypeUtil.fromName(type);
				if (aClass == null)
				{
					if ("String".equals(type))
						aClass = java.lang.String.class;
					else if ("URL".equals(type))
						aClass = java.net.URL.class;
					else if ("InetAddress".equals(type))
						aClass = java.net.InetAddress.class;
					else
						aClass = Loader.loadClass(XmlConfiguration.class, type, true);
				}
			}

			Object al = null;

			Iterator iter = node.iterator("Item");
			while (iter.hasNext())
			{
				XmlParser.Node item = (XmlParser.Node)iter.next();
				String nid = item.getAttribute("id");
				Object v = value(obj, item);
				al = LazyList.add(al, (v == null && aClass.isPrimitive()) ? ZERO : v);
				if (nid != null)
					_idMap.put(nid, v);
			}

			Object array = LazyList.toArray(al, aClass);
			if (id != null)
				_idMap.put(id, array);
			return array;
		}

		/* ------------------------------------------------------------ */
		/*
		 * Create a new map object.
		 */
		private Object newMap(Object obj, XmlParser.Node node) throws Exception
		{
			String id = node.getAttribute("id");

			Map<Object, Object> map = new HashMap<Object, Object>();
			if (id != null)
				_idMap.put(id, map);

			for (int i = 0; i < node.size(); i++)
			{
				Object o = node.get(i);
				if (o instanceof String)
					continue;
				XmlParser.Node entry = (XmlParser.Node)o;
				if (!entry.getTag().equals("Entry"))
					throw new IllegalStateException("Not an Entry");

				XmlParser.Node key = null;
				XmlParser.Node value = null;

				for (int j = 0; j < entry.size(); j++)
				{
					o = entry.get(j);
					if (o instanceof String)
						continue;
					XmlParser.Node item = (XmlParser.Node)o;
					if (!item.getTag().equals("Item"))
						throw new IllegalStateException("Not an Item");
					if (key == null)
						key = item;
					else
						value = item;
				}

				if (key == null || value == null)
					throw new IllegalStateException("Missing Item in Entry");
				String kid = key.getAttribute("id");
				String vid = value.getAttribute("id");

				Object k = value(obj, key);
				Object v = value(obj, value);
				map.put(k, v);

				if (kid != null)
					_idMap.put(kid, k);
				if (vid != null)
					_idMap.put(vid, v);
			}

			return map;
		}

		/* ------------------------------------------------------------ */
		/*
		 * Create a new value object.
		 * 
		 * @param obj @param node @return @exception Exception
		 */
		private Object propertyObj(Object obj, XmlParser.Node node) throws Exception
		{
			String id = node.getAttribute("id");
			String name = node.getAttribute("name");
			String defval = node.getAttribute("default");
			Object prop = null;
			if (_propertyMap != null && _propertyMap.containsKey(name))
				prop = _propertyMap.get(name);
			else
				prop = defval;
			if (id != null)
				_idMap.put(id, prop);
			if (prop != null)
				configure(prop, node, 0);
			return prop;
		}

		/* ------------------------------------------------------------ */
		/*
		 * Get the value of an element. If no value type is specified, then white space is trimmed out of the value. If it contains multiple value elements they
		 * are added as strings before being converted to any specified type. @param node
		 */
		@SuppressWarnings("null")
		private Object value(Object obj, XmlParser.Node node) throws Exception
		{
			Object value = null;

			// Get the type
			String type = node.getAttribute("type");

			// Try a ref lookup
			String ref = node.getAttribute("ref");
			if (ref != null)
			{
				value = _idMap.get(ref);
			}
			else
			{
				// handle trivial case
				if (node.size() == 0)
				{
					if ("String".equals(type))
						return "";
					return null;
				}

				// Trim values
				int first = 0;
				int last = node.size() - 1;

				// Handle default trim type
				if (type == null || !"String".equals(type))
				{
					// Skip leading white
					Object item = null;
					while (first <= last)
					{
						item = node.get(first);
						if (!(item instanceof String))
							break;
						item = ((String)item).trim();
						if (((String)item).length() > 0)
							break;
						first++;
					}

					// Skip trailing white
					while (first < last)
					{
						item = node.get(last);
						if (!(item instanceof String))
							break;
						item = ((String)item).trim();
						if (((String)item).length() > 0)
							break;
						last--;
					}

					// All white, so return null
					if (first > last)
						return null;
				}

				if (first == last)
					// Single Item value
					value = itemValue(obj, node.get(first));
				else
				{
					// Get the multiple items as a single string
					StringBuilder buf = new StringBuilder();
					for (int i = first; i <= last; i++)
					{
						Object item = node.get(i);
						buf.append(itemValue(obj, item));
					}
					value = buf.toString();
				}
			}

			// Untyped or unknown
			if (value == null)
			{
				if ("String".equals(type))
					return "";
				return null;
			}

			// Try to type the object
			if (type == null)
			{
				if (value != null && value instanceof String)
					return ((String)value).trim();
				return value;
			}

			if ("String".equals(type) || "java.lang.String".equals(type))
				return value.toString();

			Class<?> pClass = TypeUtil.fromName(type);
			if (pClass != null)
				return TypeUtil.valueOf(pClass, value.toString());

			if ("URL".equals(type) || "java.net.URL".equals(type))
			{
				if (value instanceof URL)
					return value;
				try
				{
					return new URL(value.toString());
				} catch (MalformedURLException e)
				{
					throw new InvocationTargetException(e);
				}
			}

			if ("InetAddress".equals(type) || "java.net.InetAddress".equals(type))
			{
				if (value instanceof InetAddress)
					return value;
				try
				{
					return InetAddress.getByName(value.toString());
				} catch (UnknownHostException e)
				{
					throw new InvocationTargetException(e);
				}
			}

			throw new IllegalStateException("Unknown type " + type);
		}

		/* ------------------------------------------------------------ */
		/*
		 * Get the value of a single element. @param obj @param item @return @exception Exception
		 */
		private Object itemValue(Object obj, Object item) throws Exception
		{
			// String value
			if (item instanceof String)
				return item;

			XmlParser.Node node = (XmlParser.Node)item;
			String tag = node.getTag();
			if ("Call".equals(tag))
				return call(obj, node);
			if ("Get".equals(tag))
				return get(obj, node);
			if ("New".equals(tag))
				return newObj(obj, node);
			if ("Ref".equals(tag))
				return refObj(obj, node);
			if ("Array".equals(tag))
				return newArray(obj, node);
			if ("Map".equals(tag))
				return newMap(obj, node);
			if ("Property".equals(tag))
				return propertyObj(obj, node);

			if ("SystemProperty".equals(tag))
			{
				String name = node.getAttribute("name");
				String defaultValue = node.getAttribute("default");
				return System.getProperty(name, defaultValue);
			}

			LOG.warn("Unknown value tag: " + node, new Throwable());
			return null;
		}
	}

	/* ------------------------------------------------------------ */
	/* ------------------------------------------------------------ */
	/* ------------------------------------------------------------ */
	/* ------------------------------------------------------------ */
	/**
	 * Run the XML configurations as a main application. The command line is used to obtain properties files (must be named '*.properties') and XmlConfiguration files.
	 * <p>
	 * Any property file on the command line is added to a combined Property instance that is passed to each configuration file via {@link XmlConfiguration#setProperties(Map)}.
	 * <p>
	 * Each configuration file on the command line is used to create a new XmlConfiguration instance and the {@link XmlConfiguration#configure()} method is used to create the configured object. If the resulting object is an instance of {@link LifeCycle}, then it is started.
	 * <p>
	 * Any IDs created in a configuration are passed to the next configuration file on the command line using {@link #getIdMap()} and {@link #setIdMap(Map)} . This allows objects with IDs created in one config file to be referenced in subsequent config files on the command line.
	 * 
	 * @param args array of property and xml configuration filenames or {@link Resource}s.
	 */
	public static void main(final String[] args) throws Exception
	{

		final AtomicReference<Throwable> exception = new AtomicReference<Throwable>();

		AccessController.doPrivileged(new PrivilegedAction()
		{

			public Object run()
			{
				try
				{

					Properties properties = null;

					// Look for properties from start.jar
					try
					{
						Class<?> config = XmlConfiguration.class.getClassLoader().loadClass("org.eclipse.jetty.start.Config");
						properties = (Properties)config.getMethod("getProperties").invoke(null);
						LOG.debug("org.eclipse.jetty.start.Config properties = {}", properties);
					}
					catch (NoClassDefFoundError e)
					{
						LOG.ignore(e);
					}
					catch (ClassNotFoundException e)
					{
						LOG.ignore(e);
					}
					catch (Exception e)
					{
						LOG.warn(e);
					}

					// If no start.config properties, use clean slate
					if (properties == null)
					{
						properties = new Properties();
						// Add System Properties
						Enumeration<?> ensysprop = System.getProperties().propertyNames();
						while (ensysprop.hasMoreElements())
						{
							String name = (String)ensysprop.nextElement();
							properties.put(name, System.getProperty(name));
						}
					}

					// For all arguments, load properties or parse XMLs
					XmlConfiguration last = null;
					Object[] obj = new Object[args.length];
					for (int i = 0; i < args.length; i++)
					{
						if (args[i].toLowerCase().endsWith(".properties"))
						{
							properties.load(Resource.newResource(args[i]).getInputStream());
						}
						else
						{
							XmlConfiguration configuration = new XmlConfiguration(Resource.newResource(args[i]).getURL());
							if (last != null)
								configuration.getIdMap().putAll(last.getIdMap());
							if (properties.size() > 0)
							{
								Map<String, String> props = new HashMap<String, String>();
								for (Object key: properties.keySet())
								{
									props.put(key.toString(), String.valueOf(properties.get(key)));
								}
								configuration.setProperties(props);
							}
							obj[i] = configuration.configure();
							last = configuration;
						}
					}

					// For all objects created by XmlConfigurations, start them if they are lifecycles.
					for (int i = 0; i < args.length; i++)
					{
						if (obj[i] instanceof LifeCycle)
						{
							LifeCycle lc = (LifeCycle)obj[i];
							if (!lc.isRunning())
								lc.start();
						}
					}
				}
				catch (AccessControlException ace)
				{
					ace.printStackTrace(System.err);
					exception.set(ace);
				}
				catch (Exception e)
				{
					LOG.debug(Log.EXCEPTION, e);
					exception.set(e);
				}
				return null;
			}
		});

		Throwable th = exception.get();
		if (th != null)
		{
			if (th instanceof Exception)
				throw (Exception)th;
			else if (th instanceof Error)
				throw (Error)th;
			else if (th instanceof RuntimeException)
				throw (RuntimeException)th;
			else if (th instanceof ThreadDeath)
				throw (ThreadDeath)th;
			throw new Error(th);
		}
	}

}
