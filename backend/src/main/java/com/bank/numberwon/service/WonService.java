package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;

import java.util.List;

public interface WonService {

    OrderTicket save(OrderTicketDTO orderTicket);

    List<OrderTicket> findByUserUserIdAndStatus(Long userId, Integer status);

    void deleteById(Long orderId);

    void updateStatus(Long orderId, int status);
}
