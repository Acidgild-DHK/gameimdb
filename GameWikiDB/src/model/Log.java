package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.GameDBConstants;

@Entity
@Table(name="logs")
public class Log implements Serializable {
	
	@Id
	@Column(name=GameDBConstants.Logs.LOG_ID_COLUMN, unique = true, nullable = false)
	String logID;
	
	@Column(name=GameDBConstants.Logs.TIME_PLAYED_COLUMN, unique = false, nullable = false)
	int timePlayed;
	
	@Column(name=GameDBConstants.Logs.RATING_COLUMN, unique=false, nullable=false)
	double rating;
	
	@Column(name=GameDBConstants.Logs.REVIEW_TEXT_COLUMN, unique=false, nullable = false)
	String reviewText;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="game_id")
	Game game;
	
	@ManyToOne
	@JoinColumn(name="platform_id")
	Platform platform;
	
	@ManyToOne
	@JoinColumn(name="username")
	User user;
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void initializeLogID() {
		this.logID = user.getUsername() + ":" + game.getGameID();
	}

	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
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

}
