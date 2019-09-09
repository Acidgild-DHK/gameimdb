package games;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
	public class Games {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="game_id",unique=true,nullable=false)
	private Integer gameId;
	
	@Column(name="game_name",nullable=true)
	private String gameName;
	
	@Column(name="publisher",nullable=true)
	private String publisher;
	
	@Column(name="release_date",nullable=true)
	private String releaseDate;
	
	@Column(name="description",nullable=true)
	private Integer description;
	
	@Column(name="ESRB",nullable=true)
	private String ESRB;
	
	@Column(name="Overpay",nullable=true)
	private String overpay;
	
	@Column(name="average_rating",nullable=true)
	private String averageRating;

	@Column(name="genre",nullable=true)
	private String genre;
	
	@Column(name="userCount", nullable=false)
	private String userCount;
	
	private Set<Games> games;
	

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameNname(String gameName) {
		this.gameName = gameName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getDescription() {
		return description;
	}

	public void setDescription(Integer description) {
		this.description = description;
	}

	public String getESRB() {
		return ESRB;
	}

	public void setESRB(String eSRB) {
		ESRB = eSRB;
	}

	public String getOverpay() {
		return overpay;
	}

	public void setOverpay(String overpay) {
		this.overpay = overpay;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUserCount() {
		return userCount;
	}

	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}

	public Set<Games> getGames() {
		return games;
	}

	public void setGames(Set<Games> games) {
		this.games = games;
	}



	@Override
	public String toString() {
		return "Games [gameId=" + gameId + ", gameName=" + gameName + ", publisher=" + publisher + ", releaseDate="
				+ releaseDate + ", description=" + description + ", ESRB=" + ESRB + ", overpay=" + overpay
				+ ", averageRating=" + averageRating + ", genre=" + genre + ", userCount=" + userCount + ", games="
				+ games + "]";
	}

	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}
}
