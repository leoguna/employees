package com.javatpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Employees;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
	@Query("SELECT e FROM Employees e WHERE e.empname LIKE :prefix%")
	List<Employees> findEmployeesByPrefix(@Param("prefix") String prefix);
}