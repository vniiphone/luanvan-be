package com.luanvan.b1910025.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://127.0.0.1:8088", maxAge = 3600)
@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        System.out.println("Hello!");
        return "Hello World";
    }
}
