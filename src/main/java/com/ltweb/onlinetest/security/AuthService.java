package com.ltweb.onlinetest.security;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
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
    @Transactional
    public void confirmUser(String token) {
        User user = userRepos.findByConfirmationToken(token);
        if (user != null && user.getConfirmationTokenExpiration().isAfter(LocalDateTime.now())) {
            user.setUserStatus(true);
            user.setConfirmationToken(null);
            user.setConfirmationTokenExpiration(null);
            userRepos.save(user);
            if(!userRepos.existsByEmailAndUserStatusTrue(user.getUsername()))
                userRepos.deleteAllByUserStatusFalseAndUsername(user.getUsername());
            if(!userRepos.existsByEmailAndUserStatusTrue(user.getEmail()))
                userRepos.deleteAllByUserStatusFalseAndUsername(user.getEmail());
        } else {
            throw new RuntimeException("Invalid or expired token");
        }
    }   
    public User getCurrentUser() {
        return userRepos.findById(getCurrentUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
