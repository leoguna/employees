package com.javatpoint.service;

import com.javatpoint.model.CombinedData;
import com.javatpoint.model.Employees;

import java.util.List;

public interface CombinedDataService {
	public List<CombinedData> getCombinedDataForEmployee(Employees employee);

	public List<CombinedData> getAllCombinedData();
}
