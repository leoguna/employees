package com.javatpoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.dto.CombinedDataFetch;
import com.javatpoint.model.CombinedData;
import com.javatpoint.model.Employees;
import com.javatpoint.service.BankingService;
import com.javatpoint.service.CombinedDataService;
import com.javatpoint.service.EmployeesService;

@Service
@Transactional
public class CombinedDataServiceImpl implements CombinedDataService {
	@Autowired
	BankingService bankingService;
	@Autowired
	EmployeesService employeesService;

	public List<CombinedData> getCombinedDataForEmployee(Employees employee) {
		CombinedDataFetch combinedDataFetch = new CombinedDataFetch(bankingService, employeesService);
		return combinedDataFetch.fetchDataForEntity(employee);
	}

	public List<CombinedData> getAllCombinedData() {
		CombinedDataFetch combinedDataFetch = new CombinedDataFetch(bankingService, employeesService);
		return combinedDataFetch.fetchAllCombinedData();

	}
}
