package com.microservices.microserviceeurekaclienty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.microserviceeurekaclienty.beans.Employee;
import com.microservices.microserviceeurekaclienty.beans.EmployeesInfo;

@Service
public class MicroserviceX {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${microservice-x.apiurl}")
	private String microserviceXApiUrl;

	public EmployeesInfo getEmployees() {
		return restTemplate.getForObject(microserviceXApiUrl + "all", EmployeesInfo.class);
	}

	public Employee getEmployeeById(Integer id) {
		return restTemplate.getForObject(microserviceXApiUrl + "id/" + id, Employee.class);
	}
}
