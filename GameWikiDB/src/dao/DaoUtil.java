package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoUtil {
	
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
