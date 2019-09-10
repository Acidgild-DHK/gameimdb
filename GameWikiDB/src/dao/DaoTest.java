package dao;

import model.User;
import service.GameService;
import service.LogService;
import service.UserService;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UserService userServ = new UserService("kurwhibble");
//		User user = userServ.getUser();
//		System.out.println(user);
		LogService logServ = new LogService("kurwhibble");
		System.out.println(logServ.getAll("1++"));
	}

}
