package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roles.management.role.bean.AppRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<AppRole, Long> {
	@Query("select r from AppRole r where r.name=?1")
	public AppRole findRole(String name);
	
    @Modifying
    @Query(value = "DELETE FROM user_roles WHERE roles_id = :id", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public int deleteRoleById(@Param("id") Long id);
	
	public AppRole findByname(String name);
}
