package com.bank.numberwon.controller;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.service.WonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/numberwon")
public class HelloWorldController {

    // OwnerService 의존성 주입
    private final WonServiceImpl wonService;

    @GetMapping
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping
    public OrderTicket addTicket(@RequestBody OrderTicketDTO orderTicket) {
        System.out.println("orderTicket = " + orderTicket);
        wonService.save(orderTicket);
        return null;
    }

    @GetMapping("/mybox")
    public List<OrderTicketDTO> getTicket() {
        List<OrderTicket> tickets = wonService.findByUserUserIdAndStatus(11L, 1);
        return tickets.stream()
                .map(ticket -> new OrderTicketDTO(ticket.getOrderId(), ticket.getUser().getUserId(), ticket.getBranchCode().getName(), ticket.getDepartmentId().getName(), ticket.getLocalDateTime(), ticket.getStatus()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/mybox/{orderId}")
    public void deleteTicket(@PathVariable Long orderId) {
        wonService.deleteById(orderId);
    }
}
