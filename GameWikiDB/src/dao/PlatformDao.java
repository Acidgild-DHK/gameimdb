package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
			Platform platform = (Platform)session.get(Platform.class, idNum);
			transaction.commit();
			return Optional.ofNullable(platform);
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return Optional.ofNullable(null);
		} finally {
			session.close();
		}
		
	}

	@Override
	public Collection<Platform> getAll() {
		// TODO Auto-generated method stub
SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		try {
			ArrayList<Platform> platforms = new ArrayList<Platform>(session.createQuery("FROM " + Platform.class.getName()).list());
			transaction.commit();
			return platforms;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		}finally {
			session.close();
		}
		
		
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
	public Collection<Platform> getAll(List<DaoUtil.DaoMap> hm, boolean and, int likeGtLt) {
		// TODO Auto-generated method stub
		SessionFactory factory = DaoUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			System.out.println(session);
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Platform> cr = cb.createQuery(Platform.class);
			Root<Platform> root = cr.from(Platform.class);
			
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
			List<Platform> pl = session.createQuery(cr).list();
			return pl;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
		
	}

}
