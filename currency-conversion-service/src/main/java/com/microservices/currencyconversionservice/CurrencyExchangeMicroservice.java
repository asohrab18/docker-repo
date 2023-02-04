package com.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CurrencyExchangeMicroservice {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ce-microservice.apiurl}")
	private String ceMicroserviceApiUrl;

	@CircuitBreaker(name = "default-ce", fallbackMethod = "getCurrencyExchangeByFallback")
	public CurrencyConversion getCurrencyExchange(String from, String to) {
		Map<String, String> uriParameters = new HashMap<String, String>();
		uriParameters.put("from", from);
		uriParameters.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(ceMicroserviceApiUrl + "from/{from}/to/{to}", CurrencyConversion.class, uriParameters);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		return currencyConversion;
	}

	public CurrencyConversion getCurrencyExchangeByFallback(Exception ex) {
		return new CurrencyConversion(0L, null, null, null, BigDecimal.ONE, null, "Default Environment");
	}
}
