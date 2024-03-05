package com.bank.numberwon.repository;

import com.bank.numberwon.dto.OrderTicketDTO;
import com.bank.numberwon.model.BankBranch;
import com.bank.numberwon.model.Department;
import com.bank.numberwon.model.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface WonRepository extends CrudRepository<OrderTicket, String> {
//}
public interface WonRepository extends JpaRepository<OrderTicket, Long> {
    List<OrderTicket> findByUser_UserIdAndStatus(Long userId, Integer status);
    List<OrderTicket> findAllByStatus(Integer status);
    List<OrderTicket> findByBranch_BranchCodeAndDepartment_DepartmentId(String branchCode, String departmentId);
    int countByStatusAndBranch_BranchCodeAndDepartment_DepartmentId(Integer status, String branchCode, String departmentId);
}
