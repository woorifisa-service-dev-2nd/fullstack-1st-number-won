package com.bank.numberwon.model;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import java.util.Date;

@Getter
@Setter
@Builder
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

    private LocalDateTime localDateTime; // Date를 LocalDateTime으로 변경

    private int status;

    private Date LocalDateTime;




}
