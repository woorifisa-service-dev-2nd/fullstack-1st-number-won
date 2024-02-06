package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.repository.WonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WonServiceImpl implements WonService {

    // JPA 의존성
    private final WonRepository wonRepository;

    @Override
    public OrderTicket save(OrderTicketDTO orderTicket) {
        return wonRepository.save(orderTicket);
    }



//    @Override
//    public OrderTicket save(OrderTicket owner) {
//        return wonRepository.save(owner);
//    }
}
