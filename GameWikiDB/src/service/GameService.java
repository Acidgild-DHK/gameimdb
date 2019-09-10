package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	
	public ArrayList<Game> getAll(String search){
		Set<Game> games = null;
		
		if (search.endsWith("+")) {
			//greater than search
			HashMap<String, Object> hm = new HashMap<String, Object>();
			Integer num = Integer.parseInt(search.replace("+", ""));
			hm.put("averageRating", num);
			hm.put("userCount", num);
			games = new HashSet<Game>(gameDao.getAll(hm, false, 1));
		}
			//like
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("gameName", "%" + search + "%");
			hm.put("publisher", "%" + search + "%");
			hm.put("description", "%" + search + "%");
			if (games != null) {
			games.addAll(gameDao.getAll(hm, false, 0));
			} else {
				games = new HashSet<Game>(gameDao.getAll(hm, false, 0));
			}
			if (games != null) {
				ArrayList<Game> gameList = new ArrayList<Game>(games);
				return gameList;
			}
			return null;
			
	}
	
	public void update(Game game) {
		game.calculate();
		gameDao.update(game);
	}
	
	public String save(Game game) {
		return gameDao.save(game);
	}
}
