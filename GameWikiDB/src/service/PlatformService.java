package service;

import java.util.Collection;
import java.util.Optional;

import dao.IDao;
import dao.PlatformDao;
import model.Platform;

public class PlatformService {
	IDao<Platform> platformDao = new PlatformDao();
	
	public Collection<Platform> getAll(){
		return platformDao.getAll();
	}
	
	public Platform getPlatform(int id) {
		Optional<Platform> platformOpt = platformDao.get(String.valueOf(id));
		if (platformOpt.isPresent()) {
			return platformOpt.get();
		} else {
			return null;
		}
	}
}
