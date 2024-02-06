package com.bank.numberwon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankBranch {
    @Id
    private String branchCode;
    private String name;

    @OneToMany(mappedBy = "branchCode")
    List<OrderTicket> orderTickets = new ArrayList<>();

    public BankBranch(String branchCode) {
        this.branchCode = branchCode;
    }
}
