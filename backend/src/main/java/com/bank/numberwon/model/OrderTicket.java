package com.bank.numberwon.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
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

    private LocalDateTime localDateTime; // Date를 LocalDateTime으로 변경

    private int status;


}
