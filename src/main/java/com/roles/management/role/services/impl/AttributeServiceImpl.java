/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.services.impl;

import com.roles.management.role.bean.Attribute;
import com.roles.management.role.bean.Document;
import com.roles.management.role.dao.AttributeRepository;
import com.roles.management.role.services.AttributeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackAngel
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public int save(Document document, List<Attribute> attributes) {
        if (attributes != null || !attributes.isEmpty()) {
            
            for (Attribute attribute : attributes) {
                System.out.println("3333333333333333"+attribute.toString()); 
           }
            for (Attribute attr : attributes) {
                attr.setDocument(document);
                attributeRepository.save(attr);

            }
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int update(List<Attribute> attributes) {
        int i=0;
        
        return 0;
        
    }

}
