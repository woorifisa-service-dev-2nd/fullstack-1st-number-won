package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.OrderTicket;

import java.util.List;

public interface WonService {

    OrderTicket save(OrderTicketDTO orderTicket);
    List<Integer> numberOfWaiting(BankBranch branch_code);
}
