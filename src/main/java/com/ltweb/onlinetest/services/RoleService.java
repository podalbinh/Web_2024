package com.ltweb.onlinetest.services;

import java.util.Optional;

import com.ltweb.onlinetest.entities.ERole;
import com.ltweb.onlinetest.entities.Role;


public interface RoleService {  
    public Optional<Role> findByRoleName(ERole rolename);
}
