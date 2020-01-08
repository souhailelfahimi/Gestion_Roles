package com.roles.management.role.services;

import java.util.List;

import com.roles.management.role.bean.AppRole;
import com.roles.management.role.bean.AppUser;


public interface UserService {
	public AppUser AddUSer(AppUser user,List<AppRole> roles);
	public AppUser findUserByUserNamme(String username);
	public AppRole AddRole(AppRole role);
        public void deleteRole(Long id);
	public void addRoleToUser(String username, String rolename);
}
