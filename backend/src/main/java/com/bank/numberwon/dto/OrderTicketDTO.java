package com.bank.numberwon.dto;

import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class OrderTicketDTO {
    private Long userId;

    private String branchCode;

    private String departmentId;

    private Date localDateTime;

    private int status;

    public Long getUserId() {
        return userId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Date getLocalDateTime() {
        return localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public OrderTicketDTO(Long userId, String branchCode, String departmentId, Date localDateTime, int status) {
        this.userId = userId;
        this.branchCode = branchCode;
        this.departmentId = departmentId;
        this.localDateTime = localDateTime;
        this.status = status;
    }


}
