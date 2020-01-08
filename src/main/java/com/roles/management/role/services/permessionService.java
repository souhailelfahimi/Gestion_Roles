package com.roles.management.role.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roles.management.role.bean.AppPermession;
import com.roles.management.role.dao.PermessionRepository;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.Query;

@Service
@Transactional
public class permessionService {

    @Autowired
    private PermessionRepository permessionRepository;

    EntityManager em;
    public AppPermession addPermession(AppPermession permession) {
        permessionRepository.save(permession);
        return null;
    }

   

}
