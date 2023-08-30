package com.example.crm.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRest {

    @RequestMapping("/")
    public String home() {
        return "appName";
    }
}
