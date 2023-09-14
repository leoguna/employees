package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.AccountTypeInfo;

@Repository
public interface AccountTypeInfoRepository extends CrudRepository<AccountTypeInfo, Integer> {

}
