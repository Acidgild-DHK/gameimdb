package service;

import java.util.ArrayList;

import model.Log;
import model.User;

public class LogService {
	UserService userServ;
	
	public LogService(String username) {
		userServ = new UserService(username);
	}
	
	public ArrayList<Log> getAll(){
		return userServ.getUserLogs();
	}
	
	public void addLog(Log log) {
		User user = userServ.getUser();
		user.getLogs().add(log);
		userServ.update(user);
	}
}
