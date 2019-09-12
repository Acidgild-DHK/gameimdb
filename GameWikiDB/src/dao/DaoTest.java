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
		// TODO Auto-generated method stub
		GameService gameServ = new GameService("Some game");
		System.out.println(gameServ.get());
		ArrayList<Game> gl = gameServ.getAll();
		for (Game game : gl) {
			System.out.println(game.toStringString());
		}
		
		UserService userServ = new UserService("karissa");
		System.out.println(userServ.getUser().getUsername());
		
		LogService logServ = new LogService("karissa");
		System.out.println(logServ.getAll());
	}

}
