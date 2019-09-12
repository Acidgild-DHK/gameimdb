package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import dao.DaoUtil;
import dao.IDao;
import dao.LogDao;
import model.Game;
import model.Log;
import model.User;

public class LogService {
	UserService userServ;
	IDao<Log> logDao = new LogDao();
	
	public LogService(String username) {
		userServ = new UserService(username);
	}
	
	public Log get(String id) {
		Log log;
		Optional<Log> opt = logDao.get(id);
		if (opt.isPresent()) {
			log = opt.get();
		} else {
			log = null;
		}
		return log;
	}
	
	public ArrayList<Log> getAll(){
//		String username = userServ.getUser().getUsername();
//		List<DaoUtil.DaoMap> dm = new ArrayList<DaoUtil.DaoMap>();
//		dm.add(new DaoUtil.DaoMap("logID", username + "%"));
//		return new ArrayList<Log>(logDao.getAll(dm, true, 0));
		return new ArrayList<Log>(userServ.getUser().getLogs());
	}
	
	public ArrayList<Log> getAll(String search){
		Set<Log> logs = new HashSet<Log>();
		
		ArrayList<Log> logList = getAll();
		for (Log log : logList) {
			if (search.endsWith("+")) {
				try {
					//see if before + is number otherwise search as a word
					Integer num = Integer.parseInt(search.replace("+", ""));
					if (log.getTimePlayed() >= num
						|| log.getRating() >= num) {
						logs.add(log);
					}
				} catch (NumberFormatException e) {
					
				}
					
			}
			if (log.getGame().getGameName().toLowerCase().contains(search.toLowerCase())
				|| log.getReviewText().toLowerCase().contains(search.toLowerCase())) {
				logs.add(log);
			}
		}
		
		logList = new ArrayList<Log>(logs);
		return logList;
		
	}
	
	public void addLog(Log log) {
		User user = userServ.getUser();
		log.setUser(user);
		log.initializeLogID();
		log.getGame().getLogs().add(log);
		log.getGame().calculate();
		logDao.save(log);
	}
	
	public void updateLog(Log log) {
		log.getGame().calculate();
		logDao.update(log);
	}
}
