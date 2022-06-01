package com.bost.microservices.currencyexchangeservice.repo;

import com.bost.microservices.currencyexchangeservice.data.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {
   CurrencyExchange findByFromAndTo(String from, String to);
}
