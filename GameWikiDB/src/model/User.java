package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import dao.GameDBConstants;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name=GameDBConstants.Users.USERNAME_COLUMN , unique=true, nullable=false)
	private String username;
	
	@Column(name=GameDBConstants.Users.PASSWORD_COLUMN, unique=false, nullable=false)
	@ColumnTransformer(read="aes_decrypt(password, 'SecretKey')", write="aes_encrypt(?, 'SecretKey')")
	private String password;
	
	@Column(name=GameDBConstants.Users.QUESTION_COLUMN, unique=false, nullable=false)
	private String question;
	
	@Column(name=GameDBConstants.Users.ANSWER_COLUMN, unique=false, nullable=false)
	@ColumnTransformer(read="aes_decrypt(answer, 'SecretKey')", write="aes_encrypt(?, 'SecretKey')")
	private String answer;
	
	@Column(name=GameDBConstants.Users.GAMER_TAG_COLUMN, unique=false, nullable=false)
	private String gamerTag;
	
	@Column(name=GameDBConstants.Users.EMAIL_COLUMN, unique=false, nullable=false)
	private String email;
	
	@Column(name=GameDBConstants.Users.NAME_COLUMN, unique=false, nullable=false)
	private String name;
	
	@Column(name=GameDBConstants.Users.AGE_COLUMN, unique=false, nullable=false)
	private int age;	
	
	@Column(name=GameDBConstants.Users.KEY_COLUMN, unique=false, nullable=false)
	private String key;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	Set<Log> logs;
	
	public User() {
		this.key = generateKey();
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", question=" + question + ", answer=" + answer
				+ ", gamerTag=" + gamerTag + ", email=" + email + ", name=" + name + ", age=" + age + ", key=" + key
				+ ", logs=" + logs + "]";
	}



	private String generateKey() {
		// TODO Auto-generated method stub
		return "SecretKey";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getKey() {
		return key;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

}
