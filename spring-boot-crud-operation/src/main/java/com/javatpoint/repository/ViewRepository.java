package com.javatpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.EmployeeBankingView;

@Repository
public interface ViewRepository extends CrudRepository<EmployeeBankingView, Integer> {
	@Query("SELECT ebv FROM EmployeeBankingView ebv WHERE ebv.account_holder_name LIKE :prefix%")
	List<EmployeeBankingView> findEmployeesByPrefix(@Param("prefix") String prefix);
}
