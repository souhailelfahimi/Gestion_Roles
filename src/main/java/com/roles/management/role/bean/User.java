package com.roles.management.role.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(unique=true)
	private String username;
	private String password;
	
	public User() {
		super();
	}

	public User(String username, String password, double latitude, double longitude) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
