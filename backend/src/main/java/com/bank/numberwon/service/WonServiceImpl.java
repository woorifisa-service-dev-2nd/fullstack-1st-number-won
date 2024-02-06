package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import com.bank.numberwon.repository.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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

    //전체 번호 조회-> 현재 대기자 보여주기
    @Override
    public List<Integer> numberOfWaiting(BankBranch bank_branch){
        return orderTicketRepository.findOrderTicketJPQL(bank_branch);
    }


//    @Override
//    public OrderTicket save(OrderTicket owner) {
//        return wonRepository.save(owner);
//    }
}
