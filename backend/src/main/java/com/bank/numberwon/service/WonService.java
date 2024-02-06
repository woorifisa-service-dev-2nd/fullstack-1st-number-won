package com.bank.numberwon.service;


import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;

public interface WonService {

    OrderTicket save(OrderTicketDTO orderTicket);
}
