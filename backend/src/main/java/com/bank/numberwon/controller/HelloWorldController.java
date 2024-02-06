package com.bank.numberwon.controller;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.service.WonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/numberwon")
public class HelloWorldController {

    // OwnerService 의존성 주입
    private final WonServiceImpl wonService;

    @GetMapping
    public String test() {
        return "Hello, world!";
    }

    @PostMapping
    public OrderTicket addOwner(@RequestBody OrderTicketDTO orderTicketDTO) throws ParseException {
        System.out.println("orderTicket = " + orderTicketDTO);
        wonService.save(orderTicketDTO);

        return null;
    }
}
