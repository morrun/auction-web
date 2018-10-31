package com.mercury.finalProject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ecb_user_profile")
public class UserProfile implements GrantedAuthority {
	private static final long serialVersionUID = 2L;
	
	@Id
	private int id;
	@Column
	private String type;
	
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", type=" + type + "]";
	}

	public UserProfile(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public UserProfile(int id) {
		super();
		this.id = id;
	}
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return type;
	}

}
