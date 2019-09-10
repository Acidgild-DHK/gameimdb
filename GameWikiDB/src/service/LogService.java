package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
		return userServ.getUserLogs();
	}
	
	public ArrayList<Log> getAll(String search){
		Set<Log> logs = new HashSet<Log>();
		
		ArrayList<Log> logList = getAll();
		for (Log log : logList) {
			if (search.endsWith("+")) {
				Integer num = Integer.parseInt(search.replace("+", ""));
				if (log.getTimePlayed() >= num
					|| log.getRating() >= num) {
					logs.add(log);
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
