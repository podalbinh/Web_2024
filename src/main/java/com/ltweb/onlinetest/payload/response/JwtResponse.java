package com.ltweb.onlinetest.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String token; 
    private String type="Bearer";
    private String username;
    private List<String> listRoles;
    public JwtResponse(String token, String username, List<String> listRoles) {
        this.token = token;
     this.username=username;
        this.listRoles = listRoles;
    }

}