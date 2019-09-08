package model;

import org.displaytag.decorator.TableDecorator;

public class GameWikiDecorator extends TableDecorator{
	public String getLogID() {
		Log log = (Log)getCurrentRowObject();
		String logID = "<a href='userLogUpdate.jsp?logID=" + log.getLogID() + "'>Update</a>";
		return logID;
	}
	
	public String getGameID() {
		Game game = (Game)getCurrentRowObject();
		String gameID = "<a href='gameUpdate.jsp?game=" + game.getGameID() + "'>Update</a>";
		return gameID;
	}
}
