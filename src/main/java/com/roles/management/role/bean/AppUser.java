package com.roles.management.role.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="User")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(unique=true)
	private String username;	
	private String password;

	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<AppRole> roles = new ArrayList<AppRole>();
	
	
	
	public AppUser() {
		super();
	}

	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;

	}

	public AppUser(long id,String username, String password) {
		super();
		this.Id=id;
		this.username = username;
		this.password = password;

	}
	

	public AppUser(String username, String password, List<AppRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(List<AppRole> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	//we should not return the password to the front-end even if it is crypted for security reasons
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	
	
	
}
