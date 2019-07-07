package com.hcl.HomeLoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.HomeLoan.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	//public Customer findCustomers(Customer customer);

	public Customer findCustomerByCustomerId(int customerId);

}
