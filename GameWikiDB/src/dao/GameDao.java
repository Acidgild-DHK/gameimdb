package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Game;
import model.User;

public class GameDao implements IDao<Game> {

	private static SessionFactory factory;
	
	public GameDao() {
		// 1. configuring hibernate
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // 2. create sessionfactory
        factory = configuration.buildSessionFactory();
	}
	@Override
	public Optional<Game> get(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Game game = (Game)session.get(Game.class, id);
		transaction.commit();
		session.close();
		return Optional.ofNullable(game);
	}

	@Override
	public Collection<Game> getAll() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Game> games = new ArrayList<Game>(session.createQuery("FROM " + Game.class.getName()).list());
		transaction.commit();
		session.close();
		return games;
	}

	@Override
	public String save(Game t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String id = session.save(t).toString();
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public void update(Game t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Game t) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
	}

}
