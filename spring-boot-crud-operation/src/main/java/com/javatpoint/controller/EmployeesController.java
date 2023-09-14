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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.Employees;
import com.javatpoint.service.EmployeesService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class EmployeesController {
	@Autowired
	EmployeesService empService;

	@GetMapping("/employees")
	private List<Employees> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/employees/{empid}")
	private Employees getAllEmployees(@PathVariable("empid") int empid) {
		return empService.getEmployeesById(empid);
	}

	@DeleteMapping("/employees/{empid}")
	private void deleteEmployees(@PathVariable("empid") int empid) {
		empService.delete(empid);
	}

	@PostMapping("/employees/create")
	private int saveEmployees(@RequestBody Employees employees) {
		empService.saveOrUpdate(employees);
		return employees.getEmpid();
	}

	@PutMapping("/employees/update")
	private Employees update(@RequestBody Employees employees) {
		empService.saveOrUpdate(employees);
		return employees;
	}

	@GetMapping("/employees/names")
	private List<Employees> getEmployeesByPrefix(@RequestParam("prefix") String prefix) {
		return empService.getEmployeesByNamePrefix(prefix);
	}

}