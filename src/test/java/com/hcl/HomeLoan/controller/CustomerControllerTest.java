package com.hcl.HomeLoan.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.HomeLoan.model.Customer;
import com.hcl.HomeLoan.serviceImpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	private MockMvc mockmvc;

	@Mock
	CustomerServiceImpl customerServiceImpl;

	Customer customer;

	@Before
	public void setUp() throws Exception {

		mockmvc = MockMvcBuilders.standaloneSetup(customerController).build();

		customer = new Customer();
		customer.setAge(25);
		customer.setCustomerId(23);
		customer.setGender("Male");
		customer.setMarriageStatus("single");
		customer.setName("raj");

	}

	@Test
	public void testCreateCustomer() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/customer").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(customer))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
