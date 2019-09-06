package model;

import java.util.Date;

public class Game {
	private int gameID;
	private String gameName;
	private String publisher;
	private Date release_date;
	private String description;
	private String esrb;
	private Double averageRating;
	private String genre;
	private int userCount;
	private String updateButton;
	
	
	
	@Override
	public String toString() {
		return "Game [gameID=" + gameID + ", gameName=" + gameName + ", publisher=" + publisher + ", release_date="
				+ release_date + ", description=" + description + ", esrb=" + esrb + ", averageRating=" + averageRating
				+ ", genre=" + genre + ", userCount=" + userCount + "]";
	}

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Game(int gameID, String gameName, String publisher, Date release_date, String description, String esrb,
			Double averageRating, String genre, int userCount, String button) {
		super();
		this.gameID = gameID;
		this.gameName = gameName;
		this.publisher = publisher;
		this.release_date = release_date;
		this.description = description;
		this.esrb = esrb;
		this.averageRating = averageRating;
		this.genre = genre;
		this.userCount = userCount;
		this.updateButton = button;
	}

	
	
	public String getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(String updateButton) {
		this.updateButton = updateButton;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEsrb() {
		return esrb;
	}

	public void setEsrb(String esrb) {
		this.esrb = esrb;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
}
