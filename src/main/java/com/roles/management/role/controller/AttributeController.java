/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

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

import com.roles.management.role.bean.Attribute;
import com.roles.management.role.bean.Document;
import com.roles.management.role.dao.AttributeRepository;
import com.roles.management.role.dao.DocumentRepository;
import com.roles.management.role.services.AttributeService;

/**
 *
 * @author BlackAngel
 */
@RestController
@RequestMapping("/attributs")
public class AttributeController {

    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping("/all")
    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Attribute> findById(@PathVariable("id") Long id) {
        return attributeRepository.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Attribute attribute) {
        attributeRepository.save(attribute);
    }
    
    

    @PostMapping("/addAttributes/{docId}/")
    public void save(@PathVariable("docId") Long docId, @RequestBody List<Attribute> attributes) {
        Document doc = documentRepository.findById(docId).get();
        attributeService.save(doc, attributes);
    }

    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        attributeRepository.deleteById(id);
    }

}
