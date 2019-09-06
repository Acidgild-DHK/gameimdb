package db;

public class GameDBConstants {
	static final String DATABASE_NAME = "imdb_games";
	//user table
	class Users{
		static final String TABLE_NAME = "users";
		static final String USERNAME_COLUMN = "username";
		static final String PASSWORD_COLUMN = "password";
		static final String PASSWORD2_COLUMN = "password2";
		static final String PASSWORD3_COLUMN = "password3";
		static final String GAMER_TAG_COLUMN = "gamertag";
		static final String NAME_COLUMN = "name";
		static final String AGE_COLUMN = "age";
		static final String EMAIL_COLUMN = "email";
	}
	
	//game table
	class Games{
		static final String TABLE_NAME = "game";
		static final String GAME_ID_COLUMN = "game_id";
		static final String PUBLISHER_COLUMN = "publisher";
		static final String RELEASE_DATE_COLUMN = "release_date";
		static final String DESCRIPTION_COLUMN = "description";
		static final String ESRB_COLUMN = "ESRB";
		static final String AVERAGE_RATING_COLUMN = "average_rating";
		static final String GENRE_COLUMN = "genre";
		static final String NAME_COLUMN = "game_name";
		static final String USER_COUNT_COLUMN = "user_count";
	}
	
	//logs table
	class Logs{
		static final String TABLE_NAME = "logs";
		static final String LOG_ID_COLUMN = "log_id";
		static final String USERNAME_COLUMN = "username";
		static final String GAME_ID_COLUMN = "game_id";
		static final String TIME_PLAYED_COLUMN = "time_played";
		static final String RATING_COLUMN = "rating";
		static final String REVIEW_TEXT_COLUMN = "review_text";
		static final String PLATFORM_COLUMN = "platform_id";
	}
	
	//platforms table
	class Platforms{
		static final String TABLE_NAME = "platforms";
		static final String PLATFORM_ID_COLUMN = "platform_id";
		static final String NAME_COLUMN = "platform_name";
	}
	
	//game platform table
	class GamePlatforms{
		static final String TABLE_NAME = "game_platform";
		static final String GAME_PLATFORM_ID = "game_platform_id";
		static final String GAME_ID_COLUMN = "game_id";
		static final String PLATFORM_ID_COLUMN = "platform_id";
	}
}

