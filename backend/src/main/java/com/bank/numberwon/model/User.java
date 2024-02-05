package com.bank.numberwon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Getter
@NoArgsConstructor
@Entity
public class User {
    private String id;
    private String password;
    private String name;
    private String phone;
    @OneToMany
    private String OrderTicket;

}
