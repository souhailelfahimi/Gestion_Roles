package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roles.management.role.bean.AppPermession;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PermessionRepository extends JpaRepository<AppPermession, Long> {

    @Modifying
    @Query(value = "DELETE FROM app_role_permessions WHERE app_role_id = :id", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public int deleteByRoleId(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO app_role_permessions  Values(:roleId ,:permId)", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public int AddNewPermission(@Param("roleId") Long roleId, @Param("permId") Long permId);

}
