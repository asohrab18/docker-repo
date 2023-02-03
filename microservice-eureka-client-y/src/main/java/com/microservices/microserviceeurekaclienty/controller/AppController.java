package com.microservices.microserviceeurekaclienty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microserviceeurekaclienty.beans.Employee;
import com.microservices.microserviceeurekaclienty.beans.EmployeesInfo;
import com.microservices.microserviceeurekaclienty.services.MicroserviceX;

@RestController
@RequestMapping("information")
public class AppController {

	@Autowired
	private MicroserviceX microserviceX;

	@GetMapping("employees")
	public EmployeesInfo getEmployees() {
		return microserviceX.getEmployees();
	}

	@GetMapping("employees/{id}")
	public Employee getEmployeesById(@PathVariable("id") Integer id) {
		if (id == 0) {
			return null;
		}
		return microserviceX.getEmployeeById(id);
	}
}
