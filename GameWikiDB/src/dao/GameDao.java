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

import model.Game;
import model.User;

public class GameDao implements IDao<Game> {
	
	public GameDao() {
        
	}
	@Override
	public Optional<Game> get(String id) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Game game = (Game)session.get(Game.class, Integer.parseInt(id));
		transaction.commit();
		session.close();
		return Optional.ofNullable(game);
	}

	@Override
	public Collection<Game> getAll() {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Game> games = new ArrayList<Game>(session.createQuery("FROM " + Game.class.getName()).list());
		transaction.commit();
		session.close();
		return games;
	}

	@Override
	public String save(Game t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String id = session.save(t).toString();
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public void update(Game t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Game t) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
	}
	@Override
	public Collection<Game> getAll(HashMap<String, Object> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		Session session = DaoUtil.getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Game> cr = cb.createQuery(Game.class);
		Root<Game> root = cr.from(Game.class);
		
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
