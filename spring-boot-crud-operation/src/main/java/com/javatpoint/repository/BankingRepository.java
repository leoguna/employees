package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Banking;

@Repository
public interface BankingRepository extends CrudRepository<Banking, Integer> {

}
