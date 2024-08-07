package com.jami.SpringSecurityDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/myBalance")
    String getBalanceDetails(){
        return "Getting Balanced Details from DB";
    }
}
