package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roles.management.role.bean.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
	@Modifying
    @Query(value = "DELETE FROM user_roles WHERE app_user_id = :id", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public int deleteByUserRolesId(@Param("id") Long id);
}
