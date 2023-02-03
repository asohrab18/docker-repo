package com.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conversion-info")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeMicroservice ceMicroservice;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable("from") String from, 
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversion currencyConversion = ceMicroservice.getCurrencyExchange(from, to);
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment() + " by RestTemplate.");
	}
}