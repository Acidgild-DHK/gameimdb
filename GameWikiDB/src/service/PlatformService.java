package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import dao.DaoUtil;
import dao.IDao;
import dao.PlatformDao;
import model.Game;
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
	
	public ArrayList<Platform> getPlatforms(String[] platformNames) {
		Set<Platform> platforms = new HashSet<Platform>();
		List<DaoUtil.DaoMap> hm = new ArrayList<DaoUtil.DaoMap>();
		for (String string : platformNames) {
			hm.add(new DaoUtil.DaoMap("name",  string));
		}
		platforms.addAll(platformDao.getAll(hm, false, 0));
		return (new ArrayList<Platform>(platforms));
	}
}
