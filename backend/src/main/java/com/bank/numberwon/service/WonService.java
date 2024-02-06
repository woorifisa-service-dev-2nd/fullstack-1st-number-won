package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;

import java.util.List;

public interface WonService {

    OrderTicket save(OrderTicketDTO orderTicket);

    List<OrderTicket> findByUserUserIdAndStatus(Long userId, Integer status);

//    int count(OrderTicket orderTicket);

    List<OrderTicket> findByBranchCode(OrderTicket orderTicket);

//    List<OrderTicket> findByDepartmentId(OrderTicket orderTicket);

    List<OrderTicket> findByStatus(OrderTicket orderTicket);
}

