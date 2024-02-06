package com.bank.numberwon.controller;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.service.WonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.text.ParseException;

=======
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
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
<<<<<<< HEAD
    public OrderTicket addOwner(@RequestBody OrderTicketDTO orderTicketDTO) throws ParseException {
        System.out.println("orderTicket = " + orderTicketDTO);
        wonService.save(orderTicketDTO);

=======
    public OrderTicket addOwner(@RequestBody OrderTicketDTO orderTicket) {
        System.out.println("orderTicket = " + orderTicket);
        wonService.save(orderTicket);
        
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
        return null;
    }
}
