package com.roles.management.role.services;

import java.util.List;

import com.roles.management.role.bean.AppRole;
import com.roles.management.role.bean.AppUser;
import com.roles.management.role.bean.User;

public interface UserService {

    public AppUser AddUSer(AppUser user, List<AppRole> roles);

    public User saveUser(User user);

    public AppUser findUserByUserNamme(String username);

    public AppRole AddRole(AppRole role);

    public void deleteRole(Long id);

    public void addRoleToUser(String username, String rolename);

    public void updateRole(AppRole role);
    
    public List<AppUser> getAllUsers();

}
