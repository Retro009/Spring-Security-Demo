package com.jami.SpringSecurityDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {
    @GetMapping("/welcome")
    String sayWelcome(){
        return "Welcome to SpringBoot Security";
    }
}
