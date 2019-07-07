package com.hcl.HomeLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.HomeLoan.model.Manager;
import com.hcl.HomeLoan.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@PostMapping("/managers")
	public String createManager(@RequestBody Manager manager) {

		return managerService.createManager(manager);
	}

	@GetMapping("/loans/manager/{id}/status/{status}")
	public List loanStatusList(@PathVariable int id, @PathVariable String status) {
		return managerService.loanApprovedOrRejectionList(id, status);

	}

	@GetMapping("/loans/customer/{customerId}")
	public String loanApproving(@PathVariable int customerId) {

		return managerService.approvingOrRejectingLoan(customerId);
	}

}
