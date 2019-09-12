package dao;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Platform;
import model.User;
import service.GameService;
import service.LogService;
import service.PlatformService;
import service.UserService;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		UserService userServ = new UserService("kurwhibble");
		System.out.println(userServ.getUser());
		
		UserService userServ2 = new UserService("karissa");
		System.out.println(userServ2.getUser());
		UserService userServ3 = new UserService("karissa2");
		System.out.println(userServ3.getUser());
	
	}

}
