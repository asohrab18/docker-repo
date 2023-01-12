package com.microservices.insuranceproviderservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("insurance-service")
public class InsuranceController {

	@GetMapping("new-plans")
	public List<String>getPlans(){
		return Arrays.asList("Platinum","Gold","Silver");
	}
}
