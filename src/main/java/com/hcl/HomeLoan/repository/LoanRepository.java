package com.hcl.HomeLoan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.model.Manager;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	
	public List<Loan> findByManager(Manager manager);
	
	public Loan findByCustomer(Customer customer);
	
	public Loan findLoanByAccountNo(int loanAccNo);
}
