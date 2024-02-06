package com.bank.numberwon.service;


import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import com.bank.numberwon.repository.WonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WonServiceImpl implements WonService {

    // JPA 의존성
    private final WonRepository wonRepository;


    public OrderTicket save(OrderTicketDTO orderTicketDTO) {
        OrderTicket ticket = OrderTicket.builder()
                .userId(new User(orderTicketDTO.getUserId()))
                .branchCode(new BankBranch(orderTicketDTO.getBranchCode()))
                .departmentId(new Department(orderTicketDTO.getDepartmentId()))
                .localDateTime(orderTicketDTO.parseLocalDateTime(orderTicketDTO.getLocalDateTime()))
                .status(orderTicketDTO.getStatus())
                .build();

        return wonRepository.save(ticket);
    }




//    @Override
//    public OrderTicket save(OrderTicket owner) {
//        return wonRepository.save(owner);
//    }
}
