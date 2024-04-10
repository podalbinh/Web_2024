package com.ltweb.onlinetest.services;

import java.util.List;

import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.models.UserDTO;

public interface UserService {

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);

    public User findByUsername(String username);

    public User saveOrUpdate(User user);

    public List<UserDTO> findAllUser();

    public User get(Long id);

    public Long create(UserDTO userDTO);

    public void delete(Long id);
}