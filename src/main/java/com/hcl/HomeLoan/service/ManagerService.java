package com.hcl.HomeLoan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.model.Manager;


@Service
public interface ManagerService {

	public String createManager(Manager manager);

	public String approvingOrRejectingLoan(int CustomerId);

	//public List<Loan> loanPendingList();

	public List<Customer> loanApprovedOrRejectionList(int managerId,String loanStatus);

}
