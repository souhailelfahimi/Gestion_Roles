package com.roles.management.role.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roles.management.role.bean.AppRole;
import com.roles.management.role.bean.AppUser;
import com.roles.management.role.dao.RoleRepository;
import com.roles.management.role.dao.UserRepository;
import com.roles.management.role.services.UserService;




@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public AppUser AddUSer(AppUser user,List<AppRole> roles) {		
		//We crypt the user's password
		
		AppUser u=new AppUser(user.getUsername(),bCryptPasswordEncoder.encode(user.getPassword()));		
		
		
		for(int i=0;i<roles.size();i++) {
			//System.out.println("=====> "+roles.get(i).getRole());
			AppRole role=roleRepository.findRole(roles.get(i).getRole());
			u.getRoles().add(role);
		}
				
		
		return userRepository.save(u);		

		
	}

	@Override
	public AppUser findUserByUserNamme(String username) {		
		return userRepository.findByUsername(username);
	}

	@Override
	public AppRole AddRole(AppRole role) {
		roleRepository.save(role);
		return null;
	}
	
	
	

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppRole role = roleRepository.findByname(rolename);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	

}
