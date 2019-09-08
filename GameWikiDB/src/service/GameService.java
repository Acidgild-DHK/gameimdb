package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.GameDao;
import dao.IDao;
import model.Game;

public class GameService {
	private IDao<Game> gameDao = new GameDao();
	private Game game;
	
	
	public GameService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameService(String gameTitle) {
		List<Game> list = getAll();
		Game otherGame = new Game();
		otherGame.setGameName(gameTitle);
		if (list.contains(otherGame)) {
			int i = list.indexOf(otherGame);
			game = list.get(i);
		} else {
			game = null;
		}
		
	}
	
	public Game get() {
		return this.game;
	}
	
	public Game get(int gameID) {
		Optional<Game> gameOpt = gameDao.get(String.valueOf(gameID));
		if (gameOpt.isPresent()) {
			return gameOpt.get();
		} else {
			return null;
		}
	}
	
	public ArrayList<Game> getAll() {
		ArrayList<Game> games = new ArrayList<>(gameDao.getAll());
		return games;
	}
	
	public void update(Game game) {
		gameDao.update(game);
	}
	
	public String save(Game game) {
		return gameDao.save(game);
	}
}
