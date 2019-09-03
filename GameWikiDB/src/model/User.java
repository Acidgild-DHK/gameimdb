package model;

public class User {
	public String username;
	public String gamerTag;
	public String email;
	
	public User() {
		
	}
	
	public User(String username, String gamerTag, String email) {
		this.username = username;
		this.gamerTag = gamerTag;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGamerTag() {
		return gamerTag;
	}

	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
