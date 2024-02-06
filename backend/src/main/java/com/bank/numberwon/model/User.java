package com.bank.numberwon.model;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
<<<<<<< HEAD
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
=======
@Entity
public class User {
    @Id
    private Long id;
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
    private String password;
    private String name;
    private String phone;

<<<<<<< HEAD
    public User(String userId) {
        this.userId = userId;
=======
    public User(Long id) {
        this.id = id;
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
    }
}
