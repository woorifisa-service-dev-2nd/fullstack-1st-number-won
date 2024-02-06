package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;

import java.text.ParseException;

public interface WonService {

    OrderTicket save(OrderTicketDTO orderTicket) throws ParseException;
}
