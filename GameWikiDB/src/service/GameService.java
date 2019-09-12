package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import dao.DaoUtil;
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
		List<DaoUtil.DaoMap> dm = new ArrayList<DaoUtil.DaoMap>();
		dm.add(new DaoUtil.DaoMap("gameName", gameTitle));
		List<Game> list = new ArrayList<Game>(gameDao.getAll(dm, true, 0));
		Game otherGame = new Game();
		otherGame.setGameName(gameTitle);
		if (list.contains(otherGame)) {
			int i = list.indexOf(otherGame);
			game = get(list.get(i).getGameID());
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
			try {
				//see if its number before + otherwise just search as a word
			List<DaoUtil.DaoMap> hm = new ArrayList<DaoUtil.DaoMap>();
			Integer num = Integer.parseInt(search.replace("+", ""));
			hm.add(new DaoUtil.DaoMap("averageRating", num));
			hm.add(new DaoUtil.DaoMap("userCount", num));
			games = new HashSet<Game>(gameDao.getAll(hm, false, 1));
			} catch (NumberFormatException e) {
				
			}
		}
			//like
		List<DaoUtil.DaoMap> hm = new ArrayList<DaoUtil.DaoMap>();
			hm.add(new DaoUtil.DaoMap("gameName", "%" + search + "%"));
			hm.add(new DaoUtil.DaoMap("publisher", "%" + search + "%"));
			hm.add(new DaoUtil.DaoMap("description", "%" + search + "%"));
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
