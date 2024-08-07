package com.jami.SpringSecurityDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/myLoans")
    String getLoanDetails(){
        return "Fetch Loan Details from DB";
    }
}
