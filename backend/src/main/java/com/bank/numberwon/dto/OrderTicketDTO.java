package com.bank.numberwon.dto;

import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import com.bank.numberwon.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@ToString
public class OrderTicketDTO {
    private String userId;

    private String branchCode;

    private String departmentId;

    private String localDateTime;

    private int status;


    @Builder
    public OrderTicketDTO(String userId, String branchCode, String departmentId, String localDateTime, int status) {
        this.userId = userId;
        this.branchCode = branchCode;
        this.departmentId = departmentId;
        this.localDateTime = localDateTime;
        this.status = status;
    }

    public LocalDateTime parseLocalDateTime(String localDateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(localDateTimeString, formatter);
    }

//        public static OrderTicketDTO from(OrderTicket orderTicket) {
//        final int id = orderTicket.getId();
//        final User userId = orderTicket.getUserId();
//        final BankBranch branchCode = orderTicket.getBranchCode();
//        final Department departmentId = orderTicket.getDepartmentId();
//        final Date Issuancetime = orderTicket.getLocalDateTime();
//        final int status = orderTicket.getStatus();
//
//        return new OrderTicketDTO(id,userId, branchCode, departmentId, Issuancetime, status);
//    }

}
