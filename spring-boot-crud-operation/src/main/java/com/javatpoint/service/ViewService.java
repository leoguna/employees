package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.EmployeeBankingView;

public interface ViewService {
	public List<EmployeeBankingView> getAllEmployeeBankingView();

	public EmployeeBankingView getEmployeeBankingViewById(int id);

	public List<EmployeeBankingView> getEmployeesByNamePrefix(String prefix);
}
