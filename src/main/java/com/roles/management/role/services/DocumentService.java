/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.services;

import com.roles.management.role.bean.Document;
import com.roles.management.role.bean.Folder;
import java.util.List;

/**
 *
 * @author BlackAngel
 */
public interface DocumentService {
    public int save(Folder folder,List<Document>documents);
}
