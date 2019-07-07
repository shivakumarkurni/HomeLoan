package com.hcl.HomeLoan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.repository.CustomerRepository;
import com.hcl.HomeLoan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String createCustomer(Customer customer) {

		if (customer != null) {

			if (customerRepository.save(customer) != null)
				return "Customer Details Saved successfully";
			else {
				return "Something went wrong";
			}
		} else {

			return "Please enter all the details";
		}

	}

}
