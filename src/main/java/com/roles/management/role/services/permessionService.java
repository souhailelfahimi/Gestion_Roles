package com.roles.management.role.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roles.management.role.bean.AppPermession;
import com.roles.management.role.dao.PermessionRepository;



@Service
@Transactional
public class permessionService {

	@Autowired
	private PermessionRepository permessionRepository;
	
	
	
	public AppPermession addPermession(AppPermession permession) {
		permessionRepository.save(permession);
		return null;
	}
	
}
