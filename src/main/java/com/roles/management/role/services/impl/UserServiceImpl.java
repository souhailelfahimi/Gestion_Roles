package com.roles.management.role.services.impl;

import com.roles.management.role.bean.AppPermession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roles.management.role.bean.AppRole;
import com.roles.management.role.bean.AppUser;
import com.roles.management.role.bean.User;
import com.roles.management.role.dao.PermessionRepository;
import com.roles.management.role.dao.RoleRepository;
import com.roles.management.role.dao.UserRepository;
import com.roles.management.role.services.UserService;
import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermessionRepository permessionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser AddUSer(AppUser user, List<AppRole> roles) {
        //We crypt the user's password

        AppUser u = new AppUser(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()));

        for (int i = 0; i < roles.size(); i++) {
            //System.out.println("=====> "+roles.get(i).getRole());
            AppRole role = roleRepository.findRole(roles.get(i).getRole());
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

    @Override
    public void deleteRole(Long id) {

        List<AppPermession> permessions = new ArrayList<>();
        //  permessions=perm
    }

    @Override
    public User saveUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRole(AppRole role) {

        AppRole NewRole = role;
        roleRepository.deleteOldPermissions(role.getId());
        for (AppPermession permession : role.getPermessions()) {

            // AppPermession p = permessionRepository.save(permession);
            permessionRepository.AddNewPermission(role.getId(), permession.getId());

        }
        NewRole.setRole(role.getName());
        roleRepository.save(NewRole);

    }

}
