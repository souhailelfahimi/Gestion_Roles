/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.dao;

import com.roles.management.role.bean.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackAngel
 */
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
