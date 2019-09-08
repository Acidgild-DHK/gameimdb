package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import dao.IDao;
import dao.UserDao;
import model.Log;
import model.User;

public class UserService {
	
	private IDao<User> userDao;
	private User user;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public UserService(String username) {
		this();
		Optional<User> opt = userDao.get(username);
		if (opt.isPresent()) {
			user = opt.get();
		} else {
			user = null;
		}
	}
	
	public ArrayList<Log> getUserLogs(){
		if (user != null) {
			ArrayList<Log> logs = new ArrayList<>(user.getLogs());
			return logs;
		}
		return null;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String save(User user) {
		return userDao.save(user);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
}
