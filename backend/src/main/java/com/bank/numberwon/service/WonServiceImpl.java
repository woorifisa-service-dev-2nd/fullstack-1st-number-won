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
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public void updateStatus(Long orderId, int status) {
        OrderTicket orderTicket = wonRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid orderTicket Id:" + orderId));
        orderTicket.setStatus(status);
        wonRepository.save(orderTicket);
    }

    public int countOrderTicket(OrderTicketDTO orderTicketDTO){
        List<OrderTicket> orderTickets = wonRepository.findAllByStatus(1);
        System.out.println("orderTickets = " + orderTickets);
        List<OrderTicket> countTickets = new ArrayList<>();
        for (OrderTicket orderTicket : orderTickets) {
            if(orderTicket.getDepartment().getDepartmentId().equals(orderTicketDTO.getDepartmentId()) ){
                if(orderTicket.getBranch().getBranchCode().equals(orderTicketDTO.getBranchCode())){
                    countTickets.add(orderTicket);
                }
            }
        }
        System.out.println("countTickets.size() = " + countTickets.size());
        System.out.println("countTickets = " + countTickets);
        return countTickets.size();
    }
}
