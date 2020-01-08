/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

import com.roles.management.role.bean.Document;
import com.roles.management.role.bean.Folder;
import com.roles.management.role.dao.FolderRepository;
import com.roles.management.role.services.FolderService;
import java.util.ArrayList;
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
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FolderService folderService;

    @GetMapping("/all")
    public List<Folder> findAll() {
        return folderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Folder> findById(@PathVariable("id") Long id) {
        return folderRepository.findById(id);
    }

//    @PostMapping("/")
//    public void save(@RequestBody Folder folder) {
//        System.out.println("salam");
//        List<Document> documents = new ArrayList<>();
//        documents.addAll(folder.getDocuments());
//        if (documents != null && !documents.isEmpty()) {
//            for (Document object : documents) {
//                object.toString();
//            }
//        }
//
//        folderService.save(folder);
//    }
    
    @PostMapping("/")
    public void save(@RequestBody Folder folder) {
        folderRepository.save(folder);
    }

    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        folderRepository.deleteById(id);
    }

    public FolderRepository getFolderRepository() {
        return folderRepository;
    }

    public void setFolderRepository(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderService getFolderService() {
        return folderService;
    }

    public void setFolderService(FolderService folderService) {
        this.folderService = folderService;
    }

}
