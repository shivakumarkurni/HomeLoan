package com.hcl.HomeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer")
	public String createCustomer(@RequestBody Customer customer) {
		
		return customerService.createCustomer(customer);
	}

}
