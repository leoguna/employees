package com.javatpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employees;
import com.javatpoint.repository.EmployeesRepository;
import com.javatpoint.service.EmployeesService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	EmployeesRepository repo;

	public List<Employees> getAllEmployees() {
		List<Employees> employees = new ArrayList<Employees>();
		repo.findAll().forEach(employees1 -> employees.add(employees1));
		return employees;
	}

	public Employees getEmployeesById(int id) {
		return repo.findById(id).orElse(null);
	}

	public void saveOrUpdate(Employees employees) {
		repo.save(employees);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public void update(Employees employees, int empid) {
		repo.save(employees);
	}

	public List<Employees> getEmployeesByNamePrefix(String prefix) {
		return repo.findEmployeesByPrefix(prefix);
	}
}
