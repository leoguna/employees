package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.AccountTypeInfo;
import com.javatpoint.model.Banking;
import com.javatpoint.model.Employees;
import com.javatpoint.service.BankingService;
import com.javatpoint.service.EmployeesService;
import com.javatpoint.service.ViewService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class AccountTypeInfoController {
	@Autowired
	ViewService viewService;
	@Autowired
	EmployeesService employeesService;
	@Autowired
	BankingService bankingService;

	@GetMapping("/view/accounttypeinfo/{empid}")
	private AccountTypeInfo getAccountTypeInfoById(@PathVariable("empid") int empid) {
		AccountTypeInfo accountTypeInfo = new AccountTypeInfo();
		Employees employees = employeesService.getEmployeesById(empid);

		if (employees != null) {
			accountTypeInfo.setEmployee_id(employees.getEmpid());
			accountTypeInfo.setEmployee_name(employees.getEmpname());
			Banking banking = bankingService.getBankingById(empid);
			if (banking != null) {
				if (banking.getAcctype().equals("Salary Account")) {
					accountTypeInfo.setAccount_type("Salary");
				} else if (banking.getAcctype().equals("Savings Account")) {
					accountTypeInfo.setAccount_type("Savings");
				} else {
					accountTypeInfo.setAccount_type("No Account Details.");
				}
			} else {
				accountTypeInfo.setAccount_type("No Banking Details.");
			}
		} else {
			accountTypeInfo.setEmployee_name("Employee Deatils Not Found.");
			accountTypeInfo.setAccount_type("Employee Details Not Found.");
		}

		return accountTypeInfo;
	}

	@GetMapping("/view/accounttypeinfo")
	private List<AccountTypeInfo> getAccountTypeInfo() {
		List<AccountTypeInfo> accountTypeInfoList = new ArrayList<>();
		List<Employees> employees = employeesService.getAllEmployees();

		if (employees != null && !employees.isEmpty()) {
			for (Employees employee : employees) {
				AccountTypeInfo accountTypeInfo = new AccountTypeInfo();
				accountTypeInfo.setEmployee_id(employee.getEmpid());
				accountTypeInfo.setEmployee_name(employee.getEmpname());
				Banking banking = bankingService.getBankingById(employee.getEmpid());
				if (banking != null) {
					if (banking.getAcctype().equals("Salary Account")) {
						accountTypeInfo.setAccount_type("Salary");
					} else if (banking.getAcctype().equals("Savings Account")) {
						accountTypeInfo.setAccount_type("Savings");
					} else {
						accountTypeInfo.setAccount_type("No Account Details.");
					}
				} else {
					accountTypeInfo.setAccount_type("No Banking Details.");
				}
				accountTypeInfoList.add(accountTypeInfo);
			}
		} else {
			AccountTypeInfo accountTypeInfo = new AccountTypeInfo();
			accountTypeInfo.setAccount_type("No Employees Found.");
			accountTypeInfoList.add(accountTypeInfo);
		}

		return accountTypeInfoList;
	}
}
