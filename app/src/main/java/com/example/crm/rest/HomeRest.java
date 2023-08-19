package com.example.crm.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRest {

    @Value("#{${crm.app.name:Test} + 12}")
    public String appName;

    @RequestMapping("/")
    public String home() {
        return appName;
    }
}
