package com.ltweb.onlinetest.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltweb.onlinetest.entities.ERole;
import com.ltweb.onlinetest.entities.Role;
import com.ltweb.onlinetest.repos.RoleRepository;
import com.ltweb.onlinetest.services.RoleService;

@Service
public class RoleServiceImp implements RoleService {
    @Override
    public Optional<Role> findByRoleName(ERole rolename) {
        return roleRepository.findByRolename(rolename);
    }

    @Autowired
    private RoleRepository roleRepository;

}
