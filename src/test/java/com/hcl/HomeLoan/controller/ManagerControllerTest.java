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
import com.hcl.HomeLoan.model.Manager;
import com.hcl.HomeLoan.serviceImpl.ManagerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ManagerControllerTest {

	@InjectMocks
	ManagerController managerController;

	@Mock
	ManagerServiceImpl managerServiceImpl;

	MockMvc mockMvc;

	Manager manager;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(managerController).build();

		manager = new Manager();
		manager.setManagerId(10);
		manager.setName("rahul");
		manager.setRole("manager");

	}

	@Test
	public void testCreateManager() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/managers").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(manager))).andExpect(status().isOk());

	}

	@Test
	public void testLoanStatusList() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/loans/manager/{id}/status/{status}", 1, "pending")
				.contentType(MediaType.ALL).accept(MediaType.ALL).content(asJsonString(manager)))
				.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testLoanApproving() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/loans/customer/{customerId}", 1).contentType(MediaType.ALL)
				.accept(MediaType.ALL).content(asJsonString(manager))).andExpect(status().isOk());
	}

}
