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
    private String Department_id;
    private String name;

    @OneToMany(mappedBy = "departmentId")
    List<OrderTicket> orderTickets = new ArrayList<>();
}