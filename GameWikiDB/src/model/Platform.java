package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.GameDBConstants;

@Entity
@Table(name="platforms")
public class Platform{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=GameDBConstants.Platforms.PLATFORM_ID_COLUMN, unique=true, nullable=false)
	Integer id;
	
	@Column(name=GameDBConstants.Platforms.NAME_COLUMN, unique=true, nullable=false)
	String name;

	
	public Platform() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
