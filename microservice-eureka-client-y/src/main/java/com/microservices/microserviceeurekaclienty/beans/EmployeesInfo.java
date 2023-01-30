package com.microservices.microserviceeurekaclienty.beans;

import java.util.List;

public class EmployeesInfo {

	private List<Employee> employees;

	public EmployeesInfo() {
	}

	public EmployeesInfo(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
