package com.bank.numberwon.model;

<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
=======
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
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579

    @ManyToOne
    @JoinColumn(name = "branch_code")
    private BankBranch branchCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentId;

<<<<<<< HEAD
    private String localDateTime;

    private int status;

    @Builder
    public OrderTicket(int id, User userId, BankBranch branchCode, Department departmentId, String localDateTime, int status) {
        this.id = id;
        this.userId = userId;
        this.branchCode = branchCode;
        this.departmentId = departmentId;
        this.localDateTime = localDateTime;
        this.status = status;
=======
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
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
    }

}
