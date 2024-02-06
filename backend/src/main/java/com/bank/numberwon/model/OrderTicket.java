package com.bank.numberwon.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@ToString
@Entity
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "branch_code")
    private BankBranch branchCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentId;

    private Date LocalDateTime;

    private int status;

}
