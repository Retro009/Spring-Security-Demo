package com.jami.SpringSecurityDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/notices")
    String getNotices(){
        return "Fetch Notices from DB";
    }
}
