package com.hcl.HomeLoan.serviceImpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.model.Manager;
import com.hcl.HomeLoan.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceImplTest {

	@Mock
	LoanRepository loanRepository;

	@InjectMocks

	LoanServiceImpl loanServiceImpl;

	@Test
	public void testApplyingLoan() {
		
		Loan loan=new Loan();
		Manager manager=new Manager();
		Customer customer=new Customer();
		loan.setAccountNo(1234);
		loan.setId(1);
		loan.setCreditScore(600);
		loan.setLoanAmount(5000);
		loan.setLoanStatus("pending");
		loan.setSecurityAmt(10000);
		loan.setCustomer(customer);
		loan.setManager(manager);
		
		Mockito.when(loanRepository.save(loan)).thenReturn(loan);
		
		String actualValue=loanServiceImpl.applyingLoan(loan);
		
		assertEquals("You have applied for loan and waiting for the manager approval", actualValue);
		

	}
	
	@Test
	public void testApplyingLoanForNegitiveCase() {
		
		Loan loan=null;
		
		Mockito.when(loanRepository.save(loan)).thenReturn(loan);
		
		String actualValue=loanServiceImpl.applyingLoan(loan);
		assertEquals("Please enter all the details when applying for the loan",actualValue);
		
		
		
	}

}
