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
import com.hcl.HomeLoan.model.Loan;
import com.hcl.HomeLoan.serviceImpl.LoanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoanControllerTest {

	@InjectMocks
	LoanController loanController;

	MockMvc mockMvc;

	@Mock
	LoanServiceImpl loanServiceImpl;

	Loan loan;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();

		loan = new Loan();
		loan.setAccountNo(123);
		loan.setCreditScore(870);
		loan.setId(1);
		loan.setLoanAmount(2000);
		loan.setLoanStatus("pending");
		loan.setSecurityAmt(4000);

	}

	@Test
	public void testApplyingLoan() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/loans").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loan))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
