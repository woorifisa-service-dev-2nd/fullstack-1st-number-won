package com.bank.numberwon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class BankBranch {
    private String branchCode;
    private String name;
    private String department;
}
