package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roles.management.role.bean.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
}
