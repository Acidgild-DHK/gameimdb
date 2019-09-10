package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		ArrayList<Platform> platforms = new ArrayList<Platform>(session.createQuery("FROM " + GameDBConstants.Platforms.TABLE_NAME).list());
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
	public Collection<Platform> getAll(HashMap<String, Object> hm, boolean and, int gtLikeLt) {
		// TODO Auto-generated method stub
		return null;
	}

}
