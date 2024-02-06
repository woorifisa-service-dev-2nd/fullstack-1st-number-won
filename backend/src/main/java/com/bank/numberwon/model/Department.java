package com.bank.numberwon.model;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
<<<<<<< HEAD
@AllArgsConstructor
=======
>>>>>>> 71eac5d278b9317ac3daa528af482cf6f0fa5579
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
