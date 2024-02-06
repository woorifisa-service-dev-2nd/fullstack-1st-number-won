package com.bank.numberwon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
    private String password;
    private String name;
    private String phone;

    public User(String userId) {
        this.userId = userId;
    }
}
