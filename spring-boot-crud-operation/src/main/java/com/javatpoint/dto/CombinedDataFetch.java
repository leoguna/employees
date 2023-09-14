package com.javatpoint.dto;

import com.javatpoint.model.Banking;
import com.javatpoint.model.CombinedData;
import com.javatpoint.model.Employees;
import com.javatpoint.repository.Fetch;
import com.javatpoint.service.BankingService;
import com.javatpoint.service.EmployeesService;

import java.util.ArrayList;
import java.util.List;

public class CombinedDataFetch implements Fetch<Employees, CombinedData> {
	private BankingService bankingService;
	private EmployeesService employeesService;

	public CombinedDataFetch(BankingService bankingService, EmployeesService employeesService) {
		this.bankingService = bankingService;
		this.employeesService = employeesService;
	}

	@Override
	public List<CombinedData> fetchDataForEntity(Employees employee) {
		List<CombinedData> combinedDataList = new ArrayList<>();
		if (employee != null) {
			CombinedData combinedData = new CombinedData();
			// combinedData.setEmployee_id(employee.getEmpid());
			combinedData.setEmployees(employee);
			Banking banking = bankingService.getBankingById(employee.getEmpid());
			combinedData.setBanking(banking);
			combinedDataList.add(combinedData);
		}
		return combinedDataList;
	}

	public List<CombinedData> fetchAllCombinedData() {
		List<CombinedData> allCombinedData = new ArrayList<>();
		List<Employees> allEmployees = employeesService.getAllEmployees();
		for (Employees employee : allEmployees) {
			List<CombinedData> combinedDataList = fetchDataForEntity(employee);
			allCombinedData.addAll(combinedDataList);
		}

		return allCombinedData;
	}
}
