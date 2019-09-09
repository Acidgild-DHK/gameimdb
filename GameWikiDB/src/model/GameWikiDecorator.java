package model;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

public class GameWikiDecorator extends TableDecorator{
	public String getLogID() {
		Log log = (Log)getCurrentRowObject();
		String logID = "<a href='userLogUpdate.jsp?logID=" + log.getLogID() + "'>Update</a>";
		return logID;
	}
	
	public String getGameID() {
		Game game = (Game)getCurrentRowObject();
		String gameID = "<a href='gameUpdate.jsp?gameId=" + game.getGameID() + "'>Update</a>";
		return gameID;
	}
	
	public String getReleaseDate() {
		Game game = (Game)getCurrentRowObject();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dat = game.getReleaseDate();
		if (dat != null) {
			String date = sf.format(dat);
			return date;
		} else {
			return "";
		}
	}
}
