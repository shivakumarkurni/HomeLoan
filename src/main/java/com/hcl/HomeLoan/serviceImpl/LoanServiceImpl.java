package com.hcl.HomeLoan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.repository.LoanRepository;
import com.hcl.HomeLoan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService  {
	
	
	@Autowired
	LoanRepository loanRepository;

	@Override
	public String applyingLoan(Loan loan) {
		
		if(loan!=null) {
			
			if(loanRepository.save(loan)!=null) {
				return "You have applied for loan and waiting for the manager approval";
			}
			else {
				return "Server down time";
				
			}
		}
		else {
			return "Please enter all the details when applying for the loan";
		}
		
		
	}

}
