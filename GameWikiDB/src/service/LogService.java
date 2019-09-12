package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
		ArrayList<Log> logs = getAll();
		System.out.println(logs + " " + id);
		Log log = logs.get(logs.indexOf(new Log(id)));
		return log;
	}
	
	public ArrayList<Log> getAll(){
		String username = userServ.getUser().getUsername();
		List<DaoUtil.DaoMap> dm = new ArrayList<DaoUtil.DaoMap>();
		dm.add(new DaoUtil.DaoMap("logID", username + "%"));
		return new ArrayList<Log>(logDao.getAll(dm, true, 0));
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
		user.getLogs().add(log);
		userServ.update(user);
	}
	
	public void updateLog(Log log) {
		log.getGame().calculate();
		userServ.update();
	}
}
