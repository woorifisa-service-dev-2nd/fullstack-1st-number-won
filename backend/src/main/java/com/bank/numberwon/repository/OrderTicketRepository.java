package com.bank.numberwon.repository;

import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderTicketRepository extends JpaRepository<OrderTicket, Long> {

    List<OrderTicket> findByStatus(int status);

    List<OrderTicket> findByBranchCode(BankBranch branchCode);

    List<OrderTicket> findByDepartmentId(Department department);


}
