package com.microservices.currencyexchangeservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public Optional<CurrencyExchange> findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);

}
