package com.bank.numberwon.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "branch_code")
    private BankBranch branch;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Date localDateTime;

    private int status;

    public static OrderTicket of(User user, BankBranch branch, Department department, Date localDateTime,
                                 int status){
        return OrderTicket.builder()
                .user(user)
                .branch(branch)
                .department(department)
                .localDateTime(localDateTime)
                .status(status).build();
    }

    public OrderTicket() {
    }
}
