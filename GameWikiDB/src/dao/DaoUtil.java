package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoUtil {
	
	public static class DaoMap{
		private String key;
		private Object value;
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof DaoMap))
				return false;
			DaoMap other = (DaoMap) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		public DaoMap() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DaoMap(String key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}		
	}
	
	private static DaoUtil instance;
	
	private static SessionFactory factory;
	
	private DaoUtil() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // 2. create sessionfactory
        factory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		if (instance == null) {
			instance = new DaoUtil();
		}
		
		return factory.openSession();
	}
}
