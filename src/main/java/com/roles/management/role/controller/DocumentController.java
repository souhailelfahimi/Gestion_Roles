/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.controller;

import com.roles.management.role.bean.Document;
import com.roles.management.role.bean.Folder;
import com.roles.management.role.dao.DocumentRepository;
import com.roles.management.role.services.DocumentService;
import com.roles.management.role.services.FolderService;
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
    @Autowired
    private DocumentService documentService;
    @Autowired
    private FolderService folderService;

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

        System.out.println("fix   Doc ////"+document.getFolder().getId());
       
       // Document doc=documentRepository.save(document);
       // System.out.println("fix   DocSave+ ////"+doc.getId());
        documentService.addOneDocumentToFolder(document.getFolder().getId(),document);

        System.out.println("fix   Doc ////" + document.getFolder().getId());

        Document doc = documentRepository.save(document);
        System.out.println("fix   DocSave+ ////" + doc.getId());
        documentService.addOneDocumentToFolder(document.getFolder().getId(), doc);
    }

    @PostMapping("/addoc/{folderId}/{docTitre}")
    public void save(@PathVariable("folderId") Long folderId, @PathVariable("docTitre") String docTitre) {
        Folder f = folderService.findById(folderId);
        Document d = new Document(docTitre, f);
        documentRepository.save(d);


    }

//    @PostMapping("/pdf/{folderId}/{location}")
//    public void save(@PathVariable("folderId") Long folderId, @PathVariable("location") String location) {
//        documentService.addDocumentFromPdf(location, folderId);
//    }
    @PostMapping("/pdf/{folderId}")
    public void save(@PathVariable("folderId") Long folderId) {
        documentService.addDocumentFromPdf("C://Users//BlackAngel//Desktop//breq//test.pdf", folderId);
    }

//    @PostMapping("/{id}")
//    public void saveIdFolder(@PathVariable("id") Long id,@RequestBody List<Document> documents) {
//        
//        documentService.addDocumentToFolder(id,documents);
//        
//    }
    @DeleteMapping("/{id]")
    public void remove(@PathVariable("id") Long id) {
        documentRepository.deleteById(id);
    }

}
