package com.microservices.microserviceeurekaclienty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.microserviceeurekaclienty.beans.Employee;
import com.microservices.microserviceeurekaclienty.beans.EmployeesInfo;

@RestController
@RequestMapping("information")
public class AppController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("employees")
	public EmployeesInfo getEmployees() {
		return restTemplate.getForObject("http://MICROSERVICE-EUREKA-CLIENT-X/employees/all", EmployeesInfo.class);
	}

	@GetMapping("employees/{id}")
	public Employee getEmployeesById(@PathVariable("id") Integer id) {
		if (id == 0) {
			return null;
		}
		return restTemplate.getForObject("http://MICROSERVICE-EUREKA-CLIENT-X/employees/id/" + id, Employee.class);
	}
}
