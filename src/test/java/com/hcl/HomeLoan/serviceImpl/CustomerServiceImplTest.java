package com.hcl.HomeLoan.serviceImpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setName("shiva");
		customer.setMobileNo(12345);
		customer.setAge(26);
		customer.setGender("Male");

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		String actualValue = customerServiceImpl.createCustomer(customer);

		assertEquals("Customer Details Saved successfully", actualValue);

	}
	
	@Test
	public void testCreateCustomerDummy() {
		Customer customer = null;
		

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		String actualValue = customerServiceImpl.createCustomer(customer);

		assertEquals("Please enter all the details", actualValue);

	}
	

}
