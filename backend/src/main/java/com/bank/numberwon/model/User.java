package com.bank.numberwon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long userId;
    private String password;
    private String name;
    private String phone;

    public User(Long userId) {
        this.userId = userId;
    }
}
