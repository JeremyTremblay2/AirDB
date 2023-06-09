package com.example.AirDB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping("/")
    public String home() {
        String uri = "mongodb://@localhost:8080";
        return "hello world";
    }
}