package com.roles.management.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.roles.management.role.bean.AppPermession;
import com.roles.management.role.bean.AppRole;
import com.roles.management.role.services.UserServiceImpl;
import com.roles.management.role.services.permessionService;

@SpringBootApplication
public class RoleApplication implements CommandLineRunner{

	@Autowired
	private UserServiceImpl userService;;
	@Autowired
	private permessionService permessionService;
	
	public static void main(String[] args) {
		SpringApplication.run(RoleApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		permessionService.addPermession(new AppPermession((long)1,"All"));
		permessionService.addPermession(new AppPermession((long)2,"ajouter"));
		permessionService.addPermession(new AppPermession((long)3,"delete"));
		permessionService.addPermession(new AppPermession((long)4,"consultation"));
		permessionService.addPermession(new AppPermession((long)5,"modification"));
				/*
		userService.AddUSer(new AppUser("admin@gmail.com","123456"));		
		
		userService.addRoleToUser("admin@gmail.com", "ADMIN");
		*/

		
	}
}
