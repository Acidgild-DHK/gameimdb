package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Query;
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
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
//		Game game = (Game)session.get(Game.class, Integer.parseInt(id));
		Query q = session.createQuery("SELECT DISTINCT g FROM Game g LEFT JOIN FETCH g.logs l LEFT JOIN FETCH g.platforms p "
				+ "WHERE g.gameID = :id");
		q.setParameter("id", Integer.parseInt(id));
		Game game;
		game = (Game) q.getSingleResult();
		transaction.commit();
		return Optional.ofNullable(game);
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return Optional.ofNullable(null);
		} finally {
			
			session.close();
		}
	}

	@Override
	public Collection<Game> getAll() {
		// TODO Auto-generated method stub
SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Game> games = null;
		try {
		games = new ArrayList<Game>(session.createQuery("SELECT DISTINCT g FROM " + Game.class.getName()  + " g "
				+ "LEFT JOIN FETCH g.logs l LEFT JOIN FETCH g.platforms p").list());
		transaction.commit();
		return games;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			
			session.close();
			
		}
	}

	@Override
	public String save(Game t) {
		// TODO Auto-generated method stub
SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
			String id = session.save(t).toString();
			transaction.commit();
			return id;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			
			session.close();
		}
		
	}

	@Override
	public void update(Game t) {
		// TODO Auto-generated method stub
SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
			session.update(t);
			transaction.commit();
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			
			session.close();
		}
	}

	@Override
	public void delete(Game t) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(t);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	@Override
	public Collection<Game> getAll(List<DaoUtil.DaoMap> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			System.out.println(session);
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Game> cr = cb.createQuery(Game.class);
			Root<Game> root = cr.from(Game.class);
			
			Predicate[] predicates = new Predicate[hm.size()];
			int count = 0;
			for (DaoUtil.DaoMap dm : hm) {
				if (likeGtLt == 0) {
					predicates[count] = cb.like(root.get(dm.getKey()), dm.getValue().toString());
					count++;
				} else if (likeGtLt == 1) {
					predicates[count] = cb.greaterThanOrEqualTo(root.get(dm.getKey()), dm.getValue().toString());
					count++;
				} else if (likeGtLt == 2) {
					predicates[count] = cb.lessThanOrEqualTo(root.get(dm.getKey()), dm.getValue().toString());
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
			List<Game> gl = session.createQuery(cr).list();
		
			return gl;
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}
	

}
