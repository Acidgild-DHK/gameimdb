package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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
	private Date releaseDate;
	
	@Column(name=GameDBConstants.Games.DESCRIPTION_COLUMN, unique=false, nullable=true)
	private String description;
	
	@Column(name=GameDBConstants.Games.ESRB_COLUMN, unique=false, nullable=true)
	private String esrb;
	
	@Column(name=GameDBConstants.Games.AVERAGE_RATING_COLUMN, unique=false, nullable=false)
	private double averageRating;
	
	@Column(name=GameDBConstants.Games.GENRE_COLUMN, unique=false, nullable=true)
	private String genre;
	
	@Column(name=GameDBConstants.Games.USER_COUNT_COLUMN, unique=false, nullable=false)
	private int userCount;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="games_platforms", joinColumns= {@JoinColumn(name="game_id")}, inverseJoinColumns= {@JoinColumn(name="platform_id")})
	private Set<Platform> platforms = new HashSet<Platform>();
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="game")
	private Set<Log> logs = new HashSet<Log>();

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Game))
			return false;
		Game other = (Game) obj;
		if (gameName == null) {
			if (other.gameName != null)
				return false;
		} else if (!gameName.equals(other.gameName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getGameName();
	}

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void calculate() {
		this.userCount = logs.size();
		if (userCount > 0) {
		this.averageRating = 0;
		for (Log log : logs) {
			this.averageRating += log.getRating();
		}
		this.averageRating = this.averageRating / userCount;
		}
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
	
	public String getReleaseDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(releaseDate);
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
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
