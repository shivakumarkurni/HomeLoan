package com.hcl.HomeLoan.service;

import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Loan;

@Service
public interface LoanService {

	public String applyingLoan(Loan loan);

}
