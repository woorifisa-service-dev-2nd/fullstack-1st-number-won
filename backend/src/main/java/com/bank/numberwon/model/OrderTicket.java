package com.bank.numberwon.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "branch_code")
    private BankBranch branchCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentId;

    private Date localDateTime;

    private int status;

    public static OrderTicket of(User user, BankBranch branchCode, Department departmentId, Date localDateTime,
                                 int status){
        return OrderTicket.builder()
                .user(user)
                .branchCode(branchCode)
                .departmentId(departmentId)
                .localDateTime(localDateTime)
                .status(status).build();
    }

}
