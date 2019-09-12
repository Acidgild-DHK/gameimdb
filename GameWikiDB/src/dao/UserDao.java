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

import model.User;

public class UserDao implements IDao<User>{
	
	public UserDao() {
	}

	@Override
	public Optional<User> get(String id) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		User user = (User)session.get(User.class, id);
		transaction.commit();
		session.close();
		return Optional.ofNullable(user);
	}

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<User> users = new ArrayList<User>(session.createQuery("FROM " + GameDBConstants.Users.TABLE_NAME + " u JOIN FETCH u.logs l JOIN FETCH l.game g JOIN FETCH l.user lu JOIN FETCH l.platform p").list());
		transaction.commit();
		session.close();
		return users;
	}

	@Override
	public String save(User t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String id = session.save(t).toString();
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
	}

	@Override
	public Collection<User> getAll(List<DaoUtil.DaoMap> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		return null;
	}

}
