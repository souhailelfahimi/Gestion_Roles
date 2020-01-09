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
import com.roles.management.role.services.FolderService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
    @Autowired
    FolderService folderService;

    @Override
    public int save(Folder folder, List<Document> documents) {
        if (documents != null || !documents.isEmpty()) {

            for (Document doc : documents) {
                System.out.println("222222222222222" + doc.toString());
            }
            for (Document doc : documents) {
                doc.setFolder(folder);
                Document d = documentRepository.save(doc);
                attributeService.save(d, doc.getAttributes());

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

    @Override
    public void addDocumentToFolder(Long id, List<Document> documents) {

        Folder f = folderService.findById(id);
        for (Document doc : documents) {

            doc.setFolder(f);
            documentRepository.save(doc);
            attributeService.save(doc, doc.getAttributes());
        }
    }

    @Override
    public void addOneDocumentToFolder(Long id, Document doc) {

        Folder f;
        f = folderService.findById(id);
<<<<<<< HEAD
        System.out.println("Folder Id "+f.getId());
           doc.setFolder(f);
            documentRepository.save(doc);
            //attributeService.save(doc, doc.getAttributes());
        
=======
        doc.setFolder(f);
        documentRepository.save(doc);
        //attributeService.save(doc, doc.getAttributes());

    }

    @Override
    public void addDocumentFromPdf(String Url, Long folderId) {
        try {
            PDDocument document = PDDocument.load(new File(Url));
            PDFTextStripper textStripper = new PDFTextStripper();
            // Get total page count of the PDF document
            int numberOfPages = document.getNumberOfPages();
            //set the first page to be extracted 
            textStripper.setStartPage(1);
            // set the last page to be extracted 
            textStripper.setEndPage(numberOfPages);
            String text = textStripper.getText(document);
            System.out.println("");
            String TextWithoutJumps = text.replaceAll("(?m)^[ \t]*\r?\n", "");
            // System.out.println(text);
            // System.out.println(TextWithoutJumps);
            String[] lines = text.split(System.getProperty("line.separator"));
            InserDataToAttributes(lines, folderId);
            document.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void InserDataToAttributes(String[] lines, Long folderId) {
        List<Attribute> Myattributes = new ArrayList<>();
        Folder myFolder = folderService.findById(folderId);
        Document d = documentRepository.save(new Document(lines[0].trim(), myFolder));

        Myattributes.add(new Attribute(lines[1].split(":")[0], lines[1].split(":")[1]));
        Myattributes.add(new Attribute(lines[2].split(":")[0], lines[2].split(":")[1]));
        Myattributes.add(new Attribute(lines[3].split(":")[0], lines[3].split(":")[1]));
        Myattributes.add(new Attribute(lines[4].split(":")[0], lines[4].split(":")[1]));
        Myattributes.add(new Attribute(lines[5].split(":")[0], lines[5].split(":")[1]));
        attributeService.save(d, Myattributes);

>>>>>>> a9792ff8a00212eae6f7791fb353f4d3b5acb6fb
    }

}
