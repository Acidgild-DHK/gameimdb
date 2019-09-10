package dao;

public class GameDBConstants {
	public static final String DATABASE_NAME = "imdb_games";
	//user table
	public class Users{
		public static final String TABLE_NAME = "users";
		public static final String USERNAME_COLUMN = "username";
		public static final String PASSWORD_COLUMN = "password";
		public static final String QUESTION_COLUMN = "question";
		public static final String ANSWER_COLUMN = "answer";
		public static final String GAMER_TAG_COLUMN = "gamertag";
		public static final String NAME_COLUMN = "name";
		public static final String AGE_COLUMN = "age";
		public static final String EMAIL_COLUMN = "email";
		public static final String KEY_COLUMN = "my_key";
	}
	
	//game table
	public class Games{
		public static final String TABLE_NAME = "game";
		public static final String GAME_ID_COLUMN = "game_id";
		public static final String PUBLISHER_COLUMN = "publisher";
		public static final String RELEASE_DATE_COLUMN = "release_date";
		public static final String DESCRIPTION_COLUMN = "description";
		public static final String ESRB_COLUMN = "ESRB";
		public static final String AVERAGE_RATING_COLUMN = "average_rating";
		public static final String GENRE_COLUMN = "genre";
		public static final String NAME_COLUMN = "game_name";
		public static final String USER_COUNT_COLUMN = "user_count";
	}
	
	//logs table
	public class Logs{
		public static final String TABLE_NAME = "logs";
		public static final String LOG_ID_COLUMN = "log_id";
		public static final String USERNAME_COLUMN = "username";
		public static final String GAME_ID_COLUMN = "game_id";
		public static final String TIME_PLAYED_COLUMN = "time_played";
		public static final String RATING_COLUMN = "rating";
		public static final String REVIEW_TEXT_COLUMN = "review_text";
		public static final String PLATFORM_COLUMN = "platform_id";
	}
	
	//platforms table
	public class Platforms{
		public static final String TABLE_NAME = "platforms";
		public static final String PLATFORM_ID_COLUMN = "platform_id";
		public static final String NAME_COLUMN = "platform_name";
	}
	
	//game platform table
	public class GamePlatforms{
		public static final String TABLE_NAME = "game_platform";
		public static final String GAME_PLATFORM_ID = "game_platform_id";
		public static final String GAME_ID_COLUMN = "game_id";
		public static final String PLATFORM_ID_COLUMN = "platform_id";
	}
}

