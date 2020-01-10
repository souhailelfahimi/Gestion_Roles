/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.management.role.bean.Attribute;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BlackAngel
 */
@Repository
@Transactional
public interface AttributeRepository extends JpaRepository<Attribute, Long>{
     @Modifying
    @Query(value = "update attribute set keyD=:key, value=:val WHERE id = :id", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public void updateAttribute(@Param("key") String key,@Param("val") String val,@Param("id") Long id);
}
