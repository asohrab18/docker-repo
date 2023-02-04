package com.microservices.microserviceeurekaclienty.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.microserviceeurekaclienty.beans.Employee;
import com.microservices.microserviceeurekaclienty.beans.EmployeesInfo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MicroserviceX {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${microservice-x.apiurl}")
	private String microserviceXApiUrl;

	@CircuitBreaker(name = "default-employees", fallbackMethod = "getEmployeesByFallback")
	public EmployeesInfo getEmployees() {
		return restTemplate.getForObject(microserviceXApiUrl + "all", EmployeesInfo.class);
	}

	public EmployeesInfo getEmployeesByFallback(Exception ex) {
		return new EmployeesInfo(Arrays.asList(new Employee(0, "Default Name", "Default Designation", "Default City", "Default Country", 0d)));
	}

	@CircuitBreaker(name = "default-emp", fallbackMethod = "getEmpByFallback")
	public Employee getEmployeeById(Integer id) {
		return restTemplate.getForObject(microserviceXApiUrl + "id/" + id, Employee.class);
	}
	
	public Employee getEmpByFallback(Exception ex) {
		return new Employee(0, "Default Name", "Default Designation", "Default City", "Default Country", 0d);
	}
}
