/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

import com.roles.management.role.bean.Role;
import com.roles.management.role.dao.RoleRepository;
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
@RequestMapping("/rols")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all")
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable("id") Long id) {
        return roleRepository.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        roleRepository.deleteById(id);
    }

}
