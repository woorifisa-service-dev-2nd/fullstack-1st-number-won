package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import com.bank.numberwon.repository.BankBranchRepository;
import com.bank.numberwon.repository.DepartementRepository;
import com.bank.numberwon.repository.UserRepository;
import com.bank.numberwon.repository.WonRepository;
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
    public void deleteById(Long orderId) {
        wonRepository.deleteById(orderId);
    }
}
