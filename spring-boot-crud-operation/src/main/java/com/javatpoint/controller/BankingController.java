package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Banking;
import com.javatpoint.service.BankingService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class BankingController {
	@Autowired
	BankingService bankingService;

	@GetMapping("/banking")
	private List<Banking> getAllBanking() {
		return bankingService.getAllBanking();
	}

	@GetMapping("/banking/{empid}")
	private Banking getAllBanking(@PathVariable("empid") int empid) {
		return bankingService.getBankingById(empid);
	}

	@DeleteMapping("/banking/{empid}")
	private void deleteBanking(@PathVariable("empid") int empid) {
		bankingService.delete(empid);
	}

	@PostMapping("/banking/create")
	private int saveBanking(@RequestBody Banking banking) {
		bankingService.saveOrUpdate(banking);
		return banking.getEmpid();
	}

	@PutMapping("/banking/update")
	private Banking update(@RequestBody Banking banking) {
		bankingService.saveOrUpdate(banking);
		return banking;
	}
}
