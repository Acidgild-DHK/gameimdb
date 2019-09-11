package dao;

import java.util.ArrayList;
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

import model.Log;
import model.Platform;
import model.User;

public class PlatformDao implements IDao<Platform>{
	
	public PlatformDao() {

	}
	
	@Override
	public Optional<Platform> get(String id) {
		// TODO Auto-generated method stub
		int idNum = Integer.parseInt(id);
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Platform platform = (Platform)session.get(Platform.class, idNum);
		transaction.commit();
		session.close();
		return Optional.ofNullable(platform);
	}

	@Override
	public Collection<Platform> getAll() {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Platform> platforms = new ArrayList<Platform>(session.createQuery("FROM " + Platform.class.getName()).list());
		transaction.commit();
		session.close();
		return platforms;
	}

	@Override
	public String save(Platform t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Platform t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Platform t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Collection<Platform> getAll(HashMap<String, Object> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Platform> cr = cb.createQuery(Platform.class);
		Root<Platform> root = cr.from(Platform.class);
		
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
