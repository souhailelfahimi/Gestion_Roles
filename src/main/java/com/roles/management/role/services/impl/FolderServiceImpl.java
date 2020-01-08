/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.services.impl;

import com.roles.management.role.bean.Folder;
import com.roles.management.role.dao.FolderRepository;
import com.roles.management.role.services.DocumentService;
import com.roles.management.role.services.FolderService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackAngel
 */
@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    private DocumentService docummentService;

    @Override
    public void save(Folder folder) {

        folderRepository.save(folder);
        docummentService.save(folder, folder.getDocuments());

    }

    public FolderRepository getFolderRepository() {
        return folderRepository;
    }

    public void setFolderRepository(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public DocumentService getDocummentService() {
        return docummentService;
    }

    public void setDocummentService(DocumentService docummentService) {
        this.docummentService = docummentService;
    }

    @Override
    public Folder findById(Long id) {
        return folderRepository.findById(id).get();
    }

}
