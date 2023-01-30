package com.microservices.microserviceeurekaclientx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microserviceeurekaclientx.beans.Employee;
import com.microservices.microserviceeurekaclientx.beans.EmployeesInfo;
import com.microservices.microserviceeurekaclientx.dao.EmployeeRepo;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping("all")
	public EmployeesInfo getEmployees() {
		EmployeesInfo employeesInfo = new EmployeesInfo();
		List<Employee> employees = employeeRepo.findAll();
		Optional<List<Employee>> employeesOpt = Optional.ofNullable(employees);
		if (employeesOpt.isPresent() && !employees.isEmpty()) {
			employeesInfo.setEmployees(employees);
			return employeesInfo;
		}
		return employeesInfo;
	}

	@GetMapping("id/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		if (id != 0) {
			Optional<Employee> employeeOpt = employeeRepo.findById(id);
			if (employeeOpt.isPresent() && !employeeOpt.isEmpty()) {
				return employeeOpt.get();
			}
		}
		return null;
	}
}
