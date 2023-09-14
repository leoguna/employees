package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.AccountTypeInfo;

public interface AccountTypeService {
	public AccountTypeInfo getAccountTypeInfoById(int id);

	public List<AccountTypeInfo> getAccountTypeInfo();
}
