package com.bost.microservices.currencyexchangeservice.controller;

import com.bost.microservices.currencyexchangeservice.data.CurrencyExchange;
import com.bost.microservices.currencyexchangeservice.repo.CurrencyExchangeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepo repo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        logger.info("retrieveExchangeValue {} from {} to",from,to);
        CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
        if (currencyExchange == null){
            throw new RuntimeException("Unable to find exchange for "+from +" to "+to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
