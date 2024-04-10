package com.ltweb.onlinetest.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.models.UserDTO;
import com.ltweb.onlinetest.repos.UserRepository;
import com.ltweb.onlinetest.services.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    private User mapToEntity(UserDTO userDTO, User user) {
        user = modelMapper.map(userDTO, User.class);
        return user;
    }

    private UserDTO mapToDTO(User user, UserDTO userDTO) {
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
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
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}