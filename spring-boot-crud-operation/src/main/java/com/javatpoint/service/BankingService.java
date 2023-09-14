package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.Banking;

public interface BankingService {
	public List<Banking> getAllBanking();

	public Banking getBankingById(int id);

	public void saveOrUpdate(Banking banking);

	public void delete(int id);

	public void update(Banking banking, int empid);
}
