package com.hcl.HomeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	
	@PostMapping("/loans")
	public String applyingLoan(@RequestBody Loan loan) {
		
		return loanService.applyingLoan(loan);
	}

}
