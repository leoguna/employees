package com.javatpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.model.AccountTypeInfo;
import com.javatpoint.repository.AccountTypeInfoRepository;
import com.javatpoint.service.AccountTypeService;

@Service
@Transactional
public class AccountTypeServiceImpl implements AccountTypeService {
	@Autowired
	AccountTypeInfoRepository accTypeRepo;

	public AccountTypeInfo getAccountTypeInfoById(int id) {
		return accTypeRepo.findById(id).get();
	}

	public List<AccountTypeInfo> getAccountTypeInfo() {
		List<AccountTypeInfo> accountTypeInfo = new ArrayList<AccountTypeInfo>();
		accTypeRepo.findAll().forEach(accountTypeInfo1 -> accountTypeInfo.add(accountTypeInfo1));
		return accountTypeInfo;
	}
}
