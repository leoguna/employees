package com.javatpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.model.EmployeeBankingView;
import com.javatpoint.repository.ViewRepository;
import com.javatpoint.service.ViewService;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewRepository viewRepo;

	public List<EmployeeBankingView> getAllEmployeeBankingView() {
		List<EmployeeBankingView> empview = new ArrayList<EmployeeBankingView>();
		viewRepo.findAll().forEach(empview1 -> empview.add(empview1));
		return empview;
	}

	public EmployeeBankingView getEmployeeBankingViewById(int id) {
		return viewRepo.findById(id).get();
	}

	public List<EmployeeBankingView> getEmployeesByNamePrefix(String prefix) {
		return viewRepo.findEmployeesByPrefix(prefix);
	}
}
