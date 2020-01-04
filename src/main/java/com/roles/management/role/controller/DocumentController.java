/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

import com.roles.management.role.bean.Document;
import com.roles.management.role.dao.DocumentRepository;
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
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping("/all")
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Document> findById(@PathVariable("id") Long id) {
        return documentRepository.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Document document) {
        documentRepository.save(document);
    }

    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        documentRepository.deleteById(id);
    }

}
