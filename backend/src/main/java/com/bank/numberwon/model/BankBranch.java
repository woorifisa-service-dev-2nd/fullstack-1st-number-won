package com.bank.numberwon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class BankBranch {
    @Id
    private String branchCode;
    private String name;

    @OneToMany(mappedBy = "branchCode")
    List<OrderTicket> orderTickets = new ArrayList<>();

}