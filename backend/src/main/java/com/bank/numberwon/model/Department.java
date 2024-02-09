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
public class Department {
    @Id
    private String departmentId;
    private String name;

    @OneToMany(mappedBy = "department")
    List<OrderTicket> orderTickets = new ArrayList<>();

    public Department(String departmentId) {
        this.departmentId = departmentId;
    }


}
