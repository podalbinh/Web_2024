package com.ltweb.onlinetest.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltweb.onlinetest.entities.ERole;
import com.ltweb.onlinetest.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByRolename(ERole roleName);
}

