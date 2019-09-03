package model;

public class Log {
	String logID; 
	String gameTitle;
	int timePlayed;
	double rating;
	String reviewText;
	String platform;
	String updateButton;
	
	
	public Log(String logID, String gameTitle, int timePlayed, double rating, String reviewText,
			String platform, String updateButton) {
		super();
		this.logID = logID;
		this.gameTitle = gameTitle;
		this.timePlayed = timePlayed;
		this.rating = rating;
		this.reviewText = reviewText;
		this.platform = platform;
		this.updateButton = updateButton;
	}
	
	
	
	@Override
	public String toString() {
		return "Log [logID=" + logID + ", gameTitle=" + gameTitle + ", timePlayed=" + timePlayed + ", rating=" + rating
				+ ", reviewText=" + reviewText + ", platform=" + platform + ", updateButton=" + updateButton + "]";
	}



	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
	}
	public String getGameTitle() {
		return gameTitle;
	}
	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	public int getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(String updateButton) {
		this.updateButton = updateButton;
	}

}
