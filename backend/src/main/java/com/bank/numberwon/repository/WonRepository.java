package com.bank.numberwon.repository;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.repository.CrudRepository;

public interface WonRepository extends CrudRepository<OrderTicket, String> {
}
