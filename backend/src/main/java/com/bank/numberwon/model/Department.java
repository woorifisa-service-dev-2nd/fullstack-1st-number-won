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
public class Department {
    @Id
    private String Department_id;
    private String name;

    @OneToMany(mappedBy = "departmentId")
    List<OrderTicket> orderTickets = new ArrayList<>();

    public Department(String department_id) {
        Department_id = department_id;
    }
}
