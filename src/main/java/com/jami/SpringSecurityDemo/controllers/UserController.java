package com.jami.SpringSecurityDemo.controllers;

import com.jami.SpringSecurityDemo.models.Customer;
import com.jami.SpringSecurityDemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody  Customer customer){
        try{
            String hashPw = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPw);
            customer = customerRepository.save(customer);
            if(customer.getId()>0)
                return ResponseEntity.status(HttpStatus.CREATED).body("User is Successfully Registered");
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Exception occur "+e.getMessage());
        }
    }
}
