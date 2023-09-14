package com.javatpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.model.Banking;
import com.javatpoint.repository.BankingRepository;
import com.javatpoint.service.BankingService;

@Service
@Transactional
public class BankingServiceImpl implements BankingService {
	@Autowired
	BankingRepository bankRepo;

	public List<Banking> getAllBanking() {
		List<Banking> banking = new ArrayList<Banking>();
		bankRepo.findAll().forEach(banking1 -> banking.add(banking1));
		return banking;
	}

	public Banking getBankingById(int id) {
		return bankRepo.findById(id).orElse(null);
	}

	public void saveOrUpdate(Banking banking) {
		bankRepo.save(banking);
	}

	public void delete(int id) {
		bankRepo.deleteById(id);
	}

	public void update(Banking banking, int empid) {
		bankRepo.save(banking);
	}
}
