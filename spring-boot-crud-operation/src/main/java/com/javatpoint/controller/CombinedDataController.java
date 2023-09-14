package com.javatpoint.controller;

import com.javatpoint.model.CombinedData;
import com.javatpoint.model.Employees;
import com.javatpoint.service.CombinedDataService;
import com.javatpoint.service.EmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class CombinedDataController {
	@Autowired
	CombinedDataService combinedDataService;
	@Autowired
	EmployeesService employeesService;

	@GetMapping("/combinedData/{employeeId}")
	public List<CombinedData> getCombinedDataForEmployee(@PathVariable("employeeId") int employeeId) {
		Employees employee = employeesService.getEmployeesById(employeeId);

		if (employee != null) {
			return combinedDataService.getCombinedDataForEmployee(employee);
		} else {
			return new ArrayList<>();
		}
	}

	@GetMapping("/combinedData/all")
	public List<CombinedData> getAllCombinedData() {
		List<Employees> employee = employeesService.getAllEmployees();

		if (employee != null) {
			return combinedDataService.getAllCombinedData();
		} else {
			return new ArrayList<>();
		}
	}

}
