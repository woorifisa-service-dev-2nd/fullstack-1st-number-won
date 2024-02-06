package com.bank.numberwon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numberwon")
public class HelloWorldController {

    @GetMapping
    public String test() {
        return "Hello, world!";
    }
}
