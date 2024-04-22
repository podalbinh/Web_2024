package com.ltweb.onlinetest.services.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ltweb.onlinetest.entities.ERole;
import com.ltweb.onlinetest.entities.Role;
import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.models.UserDTO;
import com.ltweb.onlinetest.repos.UserRepository;
import com.ltweb.onlinetest.services.RoleService;
import com.ltweb.onlinetest.services.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;
    private User mapToEntity(UserDTO userDTO, User user) {
        user = modelMapper.map(userDTO, User.class);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        return user;
    }

    private UserDTO mapToDTO(User user, UserDTO userDTO) {
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailAndUserStatusTrue(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsernameAndUserStatusTrue(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll().stream().map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Long create(UserDTO userDTO) {
        User user = new User();
        user= mapToEntity(userDTO, user);
        user.setUserStatus(true);
        Set<String> roles = userDTO.getListRoles();
        Set<Role> listRoles = new HashSet<>();
        if (roles == null) {
            // User quyen mac dinh
            Role userRoles = roleService.findByRoleName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Role is not found"));
            listRoles.add(userRoles);
        } else {
            roles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRoles = roleService.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(adminRoles);
                        break;
                    case "moderator":
                        Role modRoles = roleService.findByRoleName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(modRoles);
                        break;
                    case "user":
                        Role userRoles = roleService.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(userRoles);
                        break;
                }
            });
        }
        user.setListRoles(listRoles);
        return userRepository.save(user).getId();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> search(String query) {
        List<User> user = userRepository.searchUser(query);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with query: " + query);
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id) .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find User with id: " + id));
        
    }
    
}