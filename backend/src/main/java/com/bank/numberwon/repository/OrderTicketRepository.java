package com.bank.numberwon.repository;

import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderTicketRepository extends JpaRepository<OrderTicket, Long> {

    @Query("SELECT COUNT(o) FROM OrderTicket o WHERE o.branchCode = :branchCode GROUP BY o.departmentId")
    List<Integer> findOrderTicketJPQL(@Param("branchCode") BankBranch branchCode);


}
