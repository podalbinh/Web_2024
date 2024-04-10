package com.ltweb.onlinetest.restcontrollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1")
public class Test {
    @GetMapping("/test")
    public String getMethodName() {
        return "12312312";
    }
    @PostMapping("/test1")
    public String postMethodName() {
       return "POST";
    }
    
    
}
