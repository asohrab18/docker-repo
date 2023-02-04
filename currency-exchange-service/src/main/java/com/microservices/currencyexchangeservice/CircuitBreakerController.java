package com.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("sample-api/retry")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	public String getSampleDataByRetry() {
		logger.info("sample-api call received: retry.");
		ResponseEntity<String> re = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return re.getBody();
	}

	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

	@GetMapping("sample-api/circuit-breaker")
	@CircuitBreaker(name = "default", fallbackMethod = "circuitBreakerResponse")
	public String getSampleDataByCircuitBreaker() {
		logger.info("sample-api call received: Circuit Breaker");
		ResponseEntity<String> re = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return re.getBody();
	}

	public String circuitBreakerResponse(Exception ex) {
		return "fallback-response by Circuit Breaker";
	}

	@GetMapping("sample-api/rate-limiter")
	@RateLimiter(name = "defaultRL")
	public String getSampleDataByRateLimiter() {
		logger.info("sample-api call received: Rate Limiter");
		return "sample-response by Rate Limiter";
	}

	@GetMapping("sample-api/bulkhead")
	@Bulkhead(name = "defaultbulk")
	public String getSampleDataByBulkHead() {
		logger.info("sample-api call received: bulkhead.");
		return "sample-response";
	}

}