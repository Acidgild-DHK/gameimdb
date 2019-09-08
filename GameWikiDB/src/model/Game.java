package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.GameDBConstants;


@Entity
@Table(name="games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name=GameDBConstants.Games.GAME_ID_COLUMN, unique=true, nullable=false)
	private int gameID;
	
	@Column(name=GameDBConstants.Games.NAME_COLUMN, unique=true, nullable=false)
	private String gameName;
	
	@Column(name=GameDBConstants.Games.PUBLISHER_COLUMN, unique=false, nullable=true)
	private String publisher;
	
	@Column(name=GameDBConstants.Games.RELEASE_DATE_COLUMN, unique=false, nullable=true)
	private Date release_date;
	
	@Column(name=GameDBConstants.Games.DESCRIPTION_COLUMN, unique=false, nullable=true)
	private String description;
	
	@Column(name=GameDBConstants.Games.ESRB_COLUMN, unique=false, nullable=true)
	private String esrb;
	
	@Column(name=GameDBConstants.Games.AVERAGE_RATING_COLUMN, unique=false, nullable=false)
	private Double averageRating;
	
	@Column(name=GameDBConstants.Games.GENRE_COLUMN, unique=false, nullable=true)
	private String genre;
	
	@Column(name=GameDBConstants.Games.USER_COUNT_COLUMN, unique=false, nullable=false)
	private int userCount;

	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Platform> platforms = new HashSet<Platform>();
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="game")
	private Set<Log> logs = new HashSet<Log>();

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(Set<Platform> platforms) {
		this.platforms = platforms;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
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
