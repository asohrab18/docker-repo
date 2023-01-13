package com.microservices.insuranceclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("client-service")
@RefreshScope
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${insurance.provider.url}")
	private String url;
	
	@SuppressWarnings("unchecked")
	@GetMapping("plans")
	public List<String> getPlans() {
		List<String> plans = restTemplate.getForObject(url, List.class);
		return plans;
	}
}
