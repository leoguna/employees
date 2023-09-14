package com.javatpoint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CombinedData {
	@Id
	@OneToOne
	private Employees employees;
	@OneToOne
	private Banking banking;

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Banking getBanking() {
		return banking;
	}

	public void setBanking(Banking banking) {
		this.banking = banking;
	}
}
