package com.roles.management.role.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roles.management.role.bean.AppUser;
import com.roles.management.role.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userService.findUserByUserNamme(username);
		if(user==null) throw new UsernameNotFoundException(username);
		
		//we only need users with the role USER in this application
		Collection<GrantedAuthority> auts=new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(r->{
			r.getPermessions().forEach(p->{
				auts.add(new SimpleGrantedAuthority(p.getName()));
			});
			
		});
		
		return new User(user.getUsername(), user.getPassword(), auts);
	}

}
