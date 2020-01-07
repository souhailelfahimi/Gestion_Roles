package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roles.management.role.bean.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
	@Query("select r from AppRole r where r.name=?1")
	public AppRole findRole(String name);
	
	
	public AppRole findByname(String name);
}
