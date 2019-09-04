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
			if (rs != null) {
				rs.next();
				gameTitle = rs.getString(GameDBConstants.Games.NAME_COLUMN);
				timePlayed = Integer.parseInt(rs.getString(GameDBConstants.Logs.TIME_PLAYED_COLUMN));
				rating = Double.parseDouble(rs.getString(GameDBConstants.Logs.RATING_COLUMN));
				reviewText = rs.getString(GameDBConstants.Logs.REVIEW_TEXT_COLUMN);
				platform = rs.getString(GameDBConstants.Logs.PLATFORM_COLUMN);
				log = new Log(null, gameTitle, timePlayed, rating, reviewText, platform, null);
			}
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return log;
	}
	
	public boolean addLog () {
		return false;
	}

}
