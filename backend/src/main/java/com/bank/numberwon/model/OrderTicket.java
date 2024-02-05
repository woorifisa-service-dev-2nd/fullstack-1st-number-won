package com.bank.numberwon.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class OrderTicket {
    private int id;
    private Date LocalDateTime;

    @ManyToOne
    @JoinColumn
    User user;

    @JoinColumn
    BankBranch bankBranch;
}
