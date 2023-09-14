package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.EmployeeBankingView;
import com.javatpoint.service.BankingService;
import com.javatpoint.service.EmployeesService;
import com.javatpoint.service.ViewService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class ViewController {
	@Autowired
	ViewService viewService;
	@Autowired
	EmployeesService employeesService;
	@Autowired
	BankingService bankingService;

	@GetMapping("/view")
	private List<EmployeeBankingView> getAllEmployeeBankingView() {
		return viewService.getAllEmployeeBankingView();
	}

	@GetMapping("/view/{empid}")
	private EmployeeBankingView getAllEmployeeBankingView(@PathVariable("empid") int empid) {
		return viewService.getEmployeeBankingViewById(empid);
	}

	@GetMapping("/view/names")
	private List<EmployeeBankingView> getEmployeesByPrefix(@RequestParam("prefix") String prefix) {
		return viewService.getEmployeesByNamePrefix(prefix);
	}
}
