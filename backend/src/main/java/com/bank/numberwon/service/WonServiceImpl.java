package com.bank.numberwon.service;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
<<<<<<< HEAD
import com.bank.numberwon.repository.WonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
=======
import com.bank.numberwon.repository.BankBranchRepository;
import com.bank.numberwon.repository.DepartementRepository;
import com.bank.numberwon.repository.UserRepository;
import com.bank.numberwon.repository.WonRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579

@Service
@RequiredArgsConstructor
public class WonServiceImpl implements WonService {

    // JPA 의존성
    private final WonRepository wonRepository;
<<<<<<< HEAD

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



=======
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


>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
//    @Override
//    public OrderTicket save(OrderTicket owner) {
//        return wonRepository.save(owner);
//    }
}
