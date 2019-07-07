package com.hcl.HomeLoan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.model.Manager;
import com.hcl.HomeLoan.repository.CustomerRepository;
import com.hcl.HomeLoan.repository.LoanRepository;
import com.hcl.HomeLoan.repository.ManagerRepository;
import com.hcl.HomeLoan.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	LoanRepository loanRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String createManager(Manager manager) {
		if (manager != null) {

			if (managerRepository.save(manager) != null) {
				return "Manager details Saved successfully";
			} else {
				return "Internal server error";
			}

		} else {
			return "Please enter all the details of the manager";
		}

	}

	@SuppressWarnings("unused")
	@Override
	public String approvingOrRejectingLoan(int customerId, String role) {

		List<Loan> loans = new ArrayList<Loan>();
		Loan loan = new Loan();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		loan = loanRepository.findByCustomer(customer);
		loans.add(loan);

		if (role.equals("manager")) {

			if (loan != null) {

				loan = loanRepository.findLoanByAccountNo(loan.getAccountNo());

				if (loans.size() > 1) {
					return "You are already having an account So you cant apply for another loan";
				} else if (loan != null) {
					customer = customerRepository.findCustomerByCustomerId(customerId);
					if ((customer.getAge() >= 24 && customer.getAge() <= 60) && loan.getCreditScore() >= 60) {
						loan.setLoanStatus("approved");
						loanRepository.save(loan);

						return "Congratulations Your Loan Has Got Approved";
					}
				}

			}
		} else {
			return "You dont have the access to approve loans ";
		}

		return null;
	}

	@Override
	public List<Customer> loanApprovedOrRejectionList(int managerId, String loanStatus) {
		List<Customer> customersList = new ArrayList<>();
		Manager manager = new Manager();
		Customer customer = new Customer();
		manager.setManagerId(managerId);

		List<Loan> loans = loanRepository.findByManager(manager);

		if (loans != null) {

			for (Loan loan : loans) {

				if (loan.getLoanStatus().equals(loanStatus)) {
					customer = customerRepository.findCustomerByCustomerId(loan.getCustomer().getCustomerId());
					customersList.add(customer);
				}
			}

		}

		return customersList;
	}

}
