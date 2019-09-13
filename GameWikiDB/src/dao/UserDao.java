package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Game;
import model.User;

public class UserDao implements IDao<User>{
	
	public UserDao() {
	}

	@Override
	public Optional<User> get(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query q = session.createQuery("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.logs l LEFT JOIN FETCH l.game LEFT JOIN FETCH l.platform "
					+ "WHERE u.username = :id ");
			q.setParameter("id", id);
			User user;
			user = (User) q.getSingleResult();
			transaction.commit();
			return Optional.ofNullable(user);
			} catch (Exception e) {
				e.printStackTrace();
				if(transaction != null) {
					transaction.rollback();
				}
				return Optional.ofNullable(null);
			} finally {
				session.close();
			}
	}

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		ArrayList<User> users = new ArrayList<User>(session.createQuery("FROM " + GameDBConstants.Users.TABLE_NAME + " u JOIN FETCH u.logs l JOIN FETCH l.game g JOIN FETCH l.user lu JOIN FETCH l.platform p").list());
		transaction.commit();
		session.close();
		DaoUtil.session = null;
		return users;
	}

	@Override
	public String save(User t) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		String id = session.save(t).toString();
		transaction.commit();
		session.close();
		DaoUtil.session = null;
		return id;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
		DaoUtil.session = null;
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
		DaoUtil.session = null;
	}

	@Override
	public Collection<User> getAll(List<DaoUtil.DaoMap> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		return null;
	}

}
