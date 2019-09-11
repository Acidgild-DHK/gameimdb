package dao;

import java.util.ArrayList;
import java.util.List;

import model.Platform;
import model.User;
import service.GameService;
import service.LogService;
import service.PlatformService;
import service.UserService;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlatformService platforms = new PlatformService();
		System.out.println(platforms.getPlatforms(new String[] {"pc","console"}));
	}

}
