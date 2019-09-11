package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Game;
import model.Log;

public class LogDao implements IDao<Log> {
	
	public LogDao() {

	}
	@Override
	public Optional<Log> get(String id) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
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
	@Override
	public Collection<Log> getAll(HashMap<String, Object> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Log> cr = cb.createQuery(Log.class);
		Root<Log> root = cr.from(Log.class);
		
		Predicate[] predicates = new Predicate[hm.size()];
		Set<String> keys = hm.keySet();
		int count = 0;
		for (String string : keys) {
			if (likeGtLt == 0) {
				predicates[count] = cb.like(root.get(string), hm.get(string).toString());
				count++;
			} else if (likeGtLt == 1) {
				predicates[count] = cb.greaterThanOrEqualTo(root.get(string), hm.get(string).toString());
				count++;
			} else if (likeGtLt == 2) {
				predicates[count] = cb.lessThanOrEqualTo(root.get(string), hm.get(string).toString());
				count++;
			} else {
				return null;
			}
		}
		if (and) {
			cr.select(root).where(cb.and(predicates));
		} else {
			cr.select(root).where(cb.or(predicates));
		}
		
		return session.createQuery(cr).list();
	}

}
