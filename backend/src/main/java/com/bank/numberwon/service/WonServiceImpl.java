package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import com.bank.numberwon.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WonServiceImpl implements WonService {

    // JPA 의존성
    private final WonRepository wonRepository;
    private final UserRepository userRepository;
    private final BankBranchRepository bankBranchRepository;
    private final DepartementRepository departementRepository;
    private final OrderTicketRepository orderTicketRepository;

    @Override
    public OrderTicket save(OrderTicketDTO orderTicketDTO) {

        User user = userRepository.findById(orderTicketDTO.getUserId()).orElse(null);
        BankBranch bankBranch = bankBranchRepository.getReferenceById(orderTicketDTO.getBranchCode());
        Department department = departementRepository.getReferenceById(orderTicketDTO.getDepartmentId());
        OrderTicket orderTicket = OrderTicket.of(user, bankBranch, department, orderTicketDTO.getLocalDateTime(), orderTicketDTO.getStatus());
        return wonRepository.save(orderTicket);
    }

    @Override
    public List<OrderTicket> findByUserUserIdAndStatus(Long userId, Integer status) {
        return wonRepository.findByUser_UserIdAndStatus(userId, status);
    }

    @Override
    public List<OrderTicket> findByStatus(OrderTicket orderTicket) {
        List<OrderTicket> validTickets = orderTicketRepository.findByStatus(orderTicket.getStatus());
        return validTickets;
    }

    @Override
    public List<OrderTicket> findByBranchCode(OrderTicket orderTicket) {
        String branchCode = orderTicket.getBranchCode().getBranchCode();
        BankBranch bankBranch = bankBranchRepository.getReferenceById(branchCode);

        List<OrderTicket> tickets = orderTicketRepository.findByBranchCode(bankBranch);
        System.out.println("tickets.size() = " + tickets.size());


        return tickets;
    }

//    @Override
//    public List<OrderTicket> findByDepartmentId(OrderTicket orderTicket) {
//        String departmentId = orderTicket.getDepartmentId().getDepartmentId();
//        Department department = departementRepository.getReferenceById(departmentId);
//
//        List<OrderTicket> tickets = orderTicketRepository.findByDepartmentId(department);
//        System.out.println("tickets.size() = " + tickets.size());
//
//        return tickets;
//    }
}
