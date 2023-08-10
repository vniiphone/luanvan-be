package com.luanvan.b1910025.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/admin/api/hello")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello!");
        return "Hello World";
    }
}
