package service;

import java.util.ArrayList;

import dao.IDao;
import dao.LogDao;
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
	
	public void addLog(Log log) {
		User user = userServ.getUser();
		log.setUser(user);
		log.initializeLogID();
		log.getGame().getLogs().add(log);
		log.getGame().calculate();
		user.getLogs().add(log);
		userServ.update(user);
	}
	
	public void updateLog() {
		userServ.update();
	}
}
