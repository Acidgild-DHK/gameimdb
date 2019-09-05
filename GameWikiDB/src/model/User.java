package model;

public class User {
	private String username;
	private String gamerTag;
	private String email;
	private String name;
	private int age;
	

	public User() {
		
	}
	
	public User(String username, String gamerTag, String email, String name, int age) {
		this.username = username;
		this.gamerTag = gamerTag;
		this.email = email;
		this.name = name;
		this.age = age;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
