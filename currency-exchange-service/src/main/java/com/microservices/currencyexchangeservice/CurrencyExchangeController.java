package com.microservices.currencyexchangeservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange-info")
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable("from") String currencyFrom, @PathVariable("to") String currencyTo) {
		Optional<CurrencyExchange> opt = repository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		if (!opt.isPresent()) {
			throw new RuntimeException("no data available from " + currencyFrom + " to " + currencyTo);
		}
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = opt.get();
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
