package dao;

import model.User;
import service.UserService;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userServ = new UserService("kurwhibble");
		User user = userServ.getUser();
		System.out.println(user);
	}

}
