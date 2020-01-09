package com.roles.management.role.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AppRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	String name;
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<AppPermession> permessions = new ArrayList<AppPermession>();
	
	public AppRole() {
		super();
	}
	public AppRole(Long id, String role) {
		super();
		Id = id;
		this.name = role;
	}
	public String getRole() {
		return name;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public void setRole(String name) {
		this.name = name;
	}
	public List<AppPermession> getPermessions() {
		return permessions;
	}
	public void setPermessions(List<AppPermession> permessions) {
		this.permessions = permessions;
	}
	@Override
	public String toString() {
		return "AppRole [Id=" + Id + ", name=" + name + "]";
	}
	
	
	
	
		
}
