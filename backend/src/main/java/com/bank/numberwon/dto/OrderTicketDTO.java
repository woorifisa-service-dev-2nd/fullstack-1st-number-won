package com.bank.numberwon.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderTicketDTO {
    private String userId;

    private String branchCode;

    private String departmentId;

    private String localDateTime;

    private int status;

    public OrderTicketDTO(String userId, String branchCode, String departmentId, String localDateTime, int status) {
        this.userId = userId;
        this.branchCode = branchCode;
        this.departmentId = departmentId;
        this.localDateTime = localDateTime;
        this.status = status;
    }

    //    public static OrderTicketDTO from(OrderTicket orderTicket) {
//        final int id = orderTicket.getId();
//        final User userId = orderTicket.getUserId();
//        final BankBranch branchCode = orderTicket.getBranchCode();
//        final Department departmentId = orderTicket.getDepartmentId();
//        final Date Issuancetime = orderTicket.getLocalDateTime();
//        final int status = orderTicket.getStatus();
//
//        return new OrderTicketDTO(id, userId, branchCode, departmentId, Issuancetime, status);
//    }

}
