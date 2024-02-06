package com.bank.numberwon.repository;

<<<<<<< HEAD
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.repository.CrudRepository;

public interface WonRepository extends CrudRepository<OrderTicket, Integer> {
=======
import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.repository.CrudRepository;

public interface WonRepository extends CrudRepository<OrderTicket, String> {
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
}
