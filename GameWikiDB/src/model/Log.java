package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.GameDBConstants;

@Entity
@Table(name="logs")
public class Log implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1233829224556457271L;

	@Id
	@Column(name=GameDBConstants.Logs.LOG_ID_COLUMN, unique = true, nullable = false)
	String logID;
	
	@Column(name=GameDBConstants.Logs.TIME_PLAYED_COLUMN, unique = false, nullable = false)
	int timePlayed;
	
	@Column(name=GameDBConstants.Logs.RATING_COLUMN, unique=false, nullable=false)
	double rating;
	
	@Column(name=GameDBConstants.Logs.REVIEW_TEXT_COLUMN, unique=false, nullable = false)
	String reviewText;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="game_id")
	Game game;
	
	@ManyToOne
	@JoinColumn(name="platform_id")
	Platform platform;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username")
	User user;
	
	
	
	@Override
	public String toString() {
		return "Log [logID=" + logID + ", timePlayed=" + timePlayed + ", rating=" + rating + ", reviewText="
				+ reviewText + ", game=" + game.getGameName() + ", platform=" + platform.getName() + ", user=" + user.getUsername() + "]";
	}

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Log(String id) {
		this.logID = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logID == null) ? 0 : logID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Log))
			return false;
		Log other = (Log) obj;
		if (logID == null) {
			if (other.logID != null)
				return false;
		} else if (!logID.equals(other.logID))
			return false;
		return true;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
