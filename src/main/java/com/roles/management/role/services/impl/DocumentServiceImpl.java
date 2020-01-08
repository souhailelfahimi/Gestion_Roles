/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.services.impl;

import com.roles.management.role.bean.Attribute;
import com.roles.management.role.bean.Document;
import com.roles.management.role.bean.Folder;
import com.roles.management.role.dao.DocumentRepository;
import com.roles.management.role.services.AttributeService;
import com.roles.management.role.services.DocumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackAngel
 */

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    AttributeService attributeService;

    @Override
    public int save(Folder folder, List<Document> documents) {
        if (documents != null || !documents.isEmpty()) {
            
             for (Document doc : documents) {
                System.out.println("222222222222222"+doc.toString()); 
           }
            for (Document doc : documents) {
                doc.setFolder(folder);
                documentRepository.save(doc);
                attributeService.save(doc, doc.getAttributes());
                
            }
            return 1;
        } else {
            return -1;
        }

    }

    public DocumentRepository getDocumentRepository() {
        return documentRepository;
    }

    public void setDocumentRepository(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public AttributeService getAttributeService() {
        return attributeService;
    }

    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
    

}