/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

import com.roles.management.role.bean.Permission;
import com.roles.management.role.dao.PermissionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BlackAngel
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
       @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping("/all")
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Permission> findById(@PathVariable("id") Long id) {
        return permissionRepository.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Permission permission) {
        permissionRepository.save(permission);
    }

    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        permissionRepository.deleteById(id);
    }
    
}
