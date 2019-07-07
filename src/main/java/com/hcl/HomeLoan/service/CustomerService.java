package com.hcl.HomeLoan.service;

import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Customer;

@Service
public interface CustomerService {

	public String createCustomer(Customer customer);

}
