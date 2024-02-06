package com.bank.numberwon.repository;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface WonRepository extends CrudRepository<OrderTicket, String> {
//}
public interface WonRepository extends CrudRepository<OrderTicket, Long> {
    List<OrderTicket> findByUser_UserIdAndStatus(Long userId, Integer status);

}
