package com.bank.numberwon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/numberwon")
    public String test() {
        return "Hello, world!";
    }
}
