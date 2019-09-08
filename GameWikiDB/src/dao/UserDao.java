package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDao implements IDao<User>{
	private static SessionFactory factory;
	
	public UserDao() {
		// 1. configuring hibernate
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // 2. create sessionfactory
        factory = configuration.buildSessionFactory();
	}

	@Override
	public Optional<User> get(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User)session.get(User.class, id);
		transaction.commit();
		
		return Optional.ofNullable(user);
	}

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<User> users = new ArrayList<User>(session.createQuery("FROM " + GameDBConstants.Users.TABLE_NAME).list());
		transaction.commit();
		return users;
	}

	@Override
	public String save(User t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String id = session.save(t).toString();
		transaction.commit();
		return id;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
	}

}
