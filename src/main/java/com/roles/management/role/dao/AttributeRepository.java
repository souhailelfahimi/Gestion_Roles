/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.management.role.bean.Attribute;

/**
 *
 * @author BlackAngel
 */
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{
    
}
