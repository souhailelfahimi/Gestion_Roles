package com.roles.management.role.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roles.management.role.bean.AppPermession;
import com.roles.management.role.bean.AppRole;
import com.roles.management.role.bean.AppUser;
import com.roles.management.role.dao.PermessionRepository;
import com.roles.management.role.dao.RoleRepository;
import com.roles.management.role.dao.UserRepository;
import com.roles.management.role.services.UserService;



@RestController
@CrossOrigin
public class UserRestController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	private PermessionRepository permessionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser user) { 
		AppUser test = userservice.findUserByUserNamme(user.getUsername());
		if(test!=null) throw new RuntimeException("User already exists !!");
		else {
			AppUser response = userservice.AddUSer(user,user.getRoles());
			return response;
		}
	}
	
	@GetMapping("/roles/getAll")
	public List<AppRole> getRoles(){
		return roleRepository.findAll();
	}
	
	@PostMapping("/roles/addroles")
	public String addRole(@RequestBody AppRole appRole) {
		


		AppRole role=new AppRole(null,appRole.getRole());
		appRole.getPermessions().forEach(p->{
			
			Optional<AppPermession> permession=permessionRepository.findById(p.getId());
			if(permession.isPresent()) {
				role.getPermessions().add(permession.get());
			}
			
		});
		roleRepository.save(role);
		
		
		
		return "role saved!";
	}
	

}