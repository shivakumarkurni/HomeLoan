package com.hcl.HomeLoan.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.model.Manager;
import com.hcl.HomeLoan.repository.CustomerRepository;
import com.hcl.HomeLoan.repository.LoanRepository;
import com.hcl.HomeLoan.repository.ManagerRepository;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceImplTest {

	@Mock
	ManagerRepository managerRepository;

	@Mock
	LoanRepository loanRepository;

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	ManagerServiceImpl managerServiceImpl;

	@Test
	public void testApprovingOrRejectingLoan() {

	}

	@Test
	public void testLoanApprovedOrRejectionList() {

		int id = 12;

		/*
		 * Manager manager = new Manager(); manager.setManagerId(id);
		 * manager.setName("Laxman"); manager.setRole("manager");
		 */

		List<Loan> loans = new ArrayList<>();
		Loan loan = new Loan();
		loan.setAccountNo(9578);
		loan.setCreditScore(900);
		loan.setId(22);
		loan.setLoanAmount(40000);
		loan.setLoanStatus("rejected");
		loan.setSecurityAmt(8000);
		// loan.setManager(manager);

		loans.add(loan);

		Mockito.when(loanRepository.findByManager(Mockito.anyObject())).thenReturn(loans);
		Customer customer = new Customer();
		customer.setAge(26);

		customer.setCustomerId(90001804);
		loan.setCustomer(customer);
		Mockito.when(customerRepository.findCustomerByCustomerId(Mockito.anyInt())).thenReturn(customer);
		managerServiceImpl.loanApprovedOrRejectionList(id, loan.getLoanStatus());
		assertEquals("rejected", loan.getLoanStatus());

	}

	@Test
	public void createManager() {
		Manager manager = new Manager();
		manager.setManagerId(12);
		manager.setName("karan");
		manager.setRole("manager");
		
		Mockito.when(managerRepository.save(manager)).thenReturn(manager);
		
		String actualValue=managerServiceImpl.createManager(manager);
		assertEquals("Manager details Saved successfully",actualValue);
		
		
	}
	
	@Test
	public void createManagers() {
		Manager manager=null;
		
		Mockito.when(managerRepository.save(manager)).thenReturn(manager);
		String actualValue=managerServiceImpl.createManager(manager);
		assertEquals("Please enter all the details of the manager",actualValue);
	}

}
