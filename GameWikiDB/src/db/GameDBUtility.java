package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Log;

public class GameDBUtility {
	
	private static GameDBUtility instance = null;

	private DB db;
	private GameDBUtility(String filename) {
		this.db = new DB(filename);
		try {
			db.connect();
			db.switchDatabase(GameDBConstants.DATABASE_NAME);
		} catch (DBExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static GameDBUtility getInstance() {
		if (instance == null) {
			instance = new GameDBUtility("app.properties");
		}
		return instance;
	}
	
//	select log_id, game_name, time_played, rating, review_text, platform_name
//	from `logs`, `game`, `platforms`
//	where username = 'kurwhibble'
//	and `logs`.game_id = `game`.game_id
//	and `logs`.platform_id = `platforms`.platform_id;
	
	public ArrayList<Log> getLogTable(String username, String button){
		ArrayList<Log> logs = new ArrayList<Log>();
		String logID = ""; 
		String gameTitle = "";
		int timePlayed;
		double rating;
		String reviewText = "";
		String platform;
		String updateButton = button;
		
		String[] columns = {GameDBConstants.Logs.LOG_ID_COLUMN, GameDBConstants.Games.NAME_COLUMN, 
				GameDBConstants.Logs.TIME_PLAYED_COLUMN, GameDBConstants.Logs.RATING_COLUMN,
				GameDBConstants.Logs.REVIEW_TEXT_COLUMN, GameDBConstants.Platforms.NAME_COLUMN};
		
		String[] tables = {GameDBConstants.Games.TABLE_NAME, GameDBConstants.Logs.TABLE_NAME, GameDBConstants.Platforms.TABLE_NAME};
		
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put(GameDBConstants.Logs.USERNAME_COLUMN, "'"+username+"'");
		hm.put(DBUtilities.tablefy(GameDBConstants.Logs.TABLE_NAME, GameDBConstants.Logs.GAME_ID_COLUMN), 
				DBUtilities.tablefy(GameDBConstants.Games.TABLE_NAME ,GameDBConstants.Games.GAME_ID_COLUMN));
		hm.put(DBUtilities.tablefy(GameDBConstants.Logs.TABLE_NAME, GameDBConstants.Logs.PLATFORM_COLUMN), 
				DBUtilities.tablefy(GameDBConstants.Platforms.TABLE_NAME, GameDBConstants.Platforms.PLATFORM_ID_COLUMN));
		
		try {
			ResultSet rs = db.getData(columns, tables, hm);
			if (rs != null) {
				while(rs.next()) {
					logID = rs.getString(GameDBConstants.Logs.LOG_ID_COLUMN);
					gameTitle = rs.getString(GameDBConstants.Games.NAME_COLUMN);
					timePlayed = Integer.parseInt(rs.getString(GameDBConstants.Logs.TIME_PLAYED_COLUMN));
					rating = Double.parseDouble(rs.getString(GameDBConstants.Logs.RATING_COLUMN));
					reviewText = rs.getString(GameDBConstants.Logs.REVIEW_TEXT_COLUMN);
					platform = rs.getString(GameDBConstants.Platforms.NAME_COLUMN);
					logs.add(new Log(logID, gameTitle, timePlayed, rating, reviewText, platform, updateButton.replace("{{logID}}", logID)));
				}
			}
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logs);
		return logs;
	}
	
	public Log getLog(String logID) {
		String gameTitle = "";
		int timePlayed;
		double rating;
		String reviewText = "";
		String platform;
		Log log = null;
		String[] columns = {GameDBConstants.Games.NAME_COLUMN, 
				GameDBConstants.Logs.TIME_PLAYED_COLUMN, GameDBConstants.Logs.RATING_COLUMN,
				GameDBConstants.Logs.REVIEW_TEXT_COLUMN, GameDBConstants.Logs.PLATFORM_COLUMN};
		
		String[] tables = {GameDBConstants.Games.TABLE_NAME, GameDBConstants.Logs.TABLE_NAME};
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put(GameDBConstants.Logs.LOG_ID_COLUMN, "'"+logID+"'");
		hm.put(DBUtilities.tablefy(GameDBConstants.Logs.TABLE_NAME, GameDBConstants.Logs.GAME_ID_COLUMN), 
				DBUtilities.tablefy(GameDBConstants.Games.TABLE_NAME ,GameDBConstants.Games.GAME_ID_COLUMN));
		
		ResultSet rs;
		try {
			rs = db.getData(columns, tables, hm);
			if (rs != null && rs.next()) {
				
				gameTitle = rs.getString(GameDBConstants.Games.NAME_COLUMN);
				timePlayed = Integer.parseInt(rs.getString(GameDBConstants.Logs.TIME_PLAYED_COLUMN));
				rating = Double.parseDouble(rs.getString(GameDBConstants.Logs.RATING_COLUMN));
				reviewText = rs.getString(GameDBConstants.Logs.REVIEW_TEXT_COLUMN);
				platform = rs.getString(GameDBConstants.Logs.PLATFORM_COLUMN);
				log = new Log(logID, gameTitle, timePlayed, rating, reviewText, platform, null);
			}
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return log;
	}
	
	/*
	 * SELECT game_id FROM game WHERE game_name='gameTitle'
	 */
	public int getGameID(String gameTitle) {
		String[] columns = {GameDBConstants.Games.GAME_ID_COLUMN};
		String[] tables = {GameDBConstants.Games.TABLE_NAME};
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put(DBUtilities.tablefy(GameDBConstants.Games.TABLE_NAME, GameDBConstants.Games.GAME_ID_COLUMN), "'" + gameTitle + "'");
		int gameID = -1;
		try {
			ResultSet rs = db.getData(columns, tables, hm);
			if (rs != null && rs.next()) {
				gameID = Integer.parseInt(rs.getString(GameDBConstants.Games.GAME_ID_COLUMN));
			}
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gameID;
	}
	
	public boolean addLog (String username, Log log) {
		int gameID = getGameID(log.getGameTitle());
		HashMap<String, String> hm = new HashMap<String, String>();
		if (gameID < 0) {
			//add game
			hm.put(GameDBConstants.Games.NAME_COLUMN, log.getGameTitle());
			try {
				db.saveData(GameDBConstants.Games.TABLE_NAME, hm);
			} catch (DBExceptions | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} 
		
		//add log
		hm.remove(GameDBConstants.Games.NAME_COLUMN);
		hm.put(GameDBConstants.Logs.USERNAME_COLUMN, username);
		hm.put(GameDBConstants.Logs.GAME_ID_COLUMN, String.valueOf(gameID));
		hm.put(GameDBConstants.Logs.RATING_COLUMN, String.valueOf(log.getRating()));
		hm.put(GameDBConstants.Logs.PLATFORM_COLUMN, log.getPlatform());
		hm.put(GameDBConstants.Logs.TIME_PLAYED_COLUMN, String.valueOf(log.getTimePlayed()));
		hm.put(GameDBConstants.Logs.REVIEW_TEXT_COLUMN, log.getReviewText());
		
		try {
			db.saveData(GameDBConstants.Logs.TABLE_NAME, hm);
			return true;
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public boolean updateLog(Log log) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put(GameDBConstants.Logs.RATING_COLUMN, String.valueOf(log.getRating()));
		hm.put(GameDBConstants.Logs.PLATFORM_COLUMN, log.getPlatform());
		hm.put(GameDBConstants.Logs.TIME_PLAYED_COLUMN, String.valueOf(log.getTimePlayed()));
		hm.put(GameDBConstants.Logs.REVIEW_TEXT_COLUMN, log.getReviewText());
		
		try {
			db.saveData(GameDBConstants.Logs.TABLE_NAME, hm, GameDBConstants.Logs.LOG_ID_COLUMN, log.getLogID());
			return true;
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
