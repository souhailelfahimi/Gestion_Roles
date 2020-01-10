/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.management.role.services;

import com.roles.management.role.bean.Attribute;
import com.roles.management.role.bean.Document;
import java.util.List;

/**
 *
 * @author BlackAngel
 */
public interface AttributeService {
    
        public int save(Document document,List<Attribute>attributes);
        public int update(List<Attribute>attributes);

}
