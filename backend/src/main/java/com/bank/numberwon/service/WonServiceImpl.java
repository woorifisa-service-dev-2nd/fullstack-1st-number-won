package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import com.bank.numberwon.repository.WonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class WonServiceImpl implements WonService {

    // JPA 의존성
    private final WonRepository wonRepository;

    @Override
    public OrderTicket save(OrderTicketDTO orderTicketDTO) throws ParseException {

//        // 포맷터
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // 문자열 -> Date
//        LocalDateTime date = LocalDateTime.parse(orderTicketDTO.getLocalDateTime(), formatter);

        // 포맷터
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        // 문자열 -> Date
//        Date date1 = formatter.parse(orderTicketDTO.getLocalDateTime());

        wonRepository.save(OrderTicket.builder()
                .userId(new User(orderTicketDTO.getUserId()))
                .branchCode(new BankBranch(orderTicketDTO.getBranchCode()))
                .departmentId(new Department(orderTicketDTO.getDepartmentId()))
                .localDateTime(orderTicketDTO.getLocalDateTime())
                .status(orderTicketDTO.getStatus()).build());


        return null;
    }



//    @Override
//    public OrderTicket save(OrderTicket owner) {
//        return wonRepository.save(owner);
//    }
}
