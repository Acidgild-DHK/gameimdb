package dao;

import java.util.Collection;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Game;
import model.Log;

public class LogDao implements IDao<Log> {

	private static SessionFactory factory;
	
	public LogDao() {
		// 1. configuring hibernate
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // 2. create sessionfactory
        factory = configuration.buildSessionFactory();
	}
	@Override
	public Optional<Log> get(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Log log = (Log)session.get(Log.class, id);
		transaction.commit();
		session.close();
		return Optional.ofNullable(log);
	}

	@Override
	public Collection<Log> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Log t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Log t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Log t) {
		// TODO Auto-generated method stub
		
	}

}
