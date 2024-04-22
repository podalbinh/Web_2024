package com.ltweb.onlinetest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.repos.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsernameAndUserStatusTrue(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        if(!user.isUserStatus()){
            throw new UsernameNotFoundException("Email has not been verified");
        }
        return CustomUserDetails.mapUserToUserDetails(user);
    }
    
}
