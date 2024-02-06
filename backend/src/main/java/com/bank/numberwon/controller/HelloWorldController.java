package com.bank.numberwon.controller;

import com.bank.numberwon.model.OrderTicket;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numberwon")
public class HelloWorldController {

    @GetMapping
    public String test() {
        return "Hello, world!";
    }

    @PostMapping("/bank")
    public String handleBankTicket(@RequestBody OrderTicket ticket) {
        System.out.println("Received Bank Ticket: " + ticket);
        return "redirect:/numberwon/";

    }
}
