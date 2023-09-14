package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.Employees;

public interface EmployeesService {
	public List<Employees> getAllEmployees();

	public Employees getEmployeesById(int id);

	public void saveOrUpdate(Employees employees);

	public void delete(int id);

	public void update(Employees employees, int empid);

	public List<Employees> getEmployeesByNamePrefix(String prefix);
}
