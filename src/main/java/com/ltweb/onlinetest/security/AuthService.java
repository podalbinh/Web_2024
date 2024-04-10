package com.ltweb.onlinetest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.repos.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepos;

    public Long getCurrentUserId() {
        CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return u.getUserId();
    }

    public User getCurrentUser() {
        return userRepos.findById(getCurrentUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
