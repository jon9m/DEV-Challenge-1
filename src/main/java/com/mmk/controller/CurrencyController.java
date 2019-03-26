package com.mmk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mmk.aop.NotFoundException;
import com.mmk.entity.Currency;
import com.mmk.entity.ProfitDetails;
import com.mmk.service.CurrencyService;

@RestController
@RequestMapping("/api")
@PropertySource({ "classpath:messages.properties" })
public class CurrencyController {

	@Autowired
	private Environment env;
	
	@Autowired
	CurrencyService currencyService;

	@GetMapping(value = "/currency/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Currency> getCurrency(@PathVariable String type) {
		List<Currency> curr = currencyService.getCurrencyListByType(type);
		if (curr == null || curr.isEmpty()) {
			throw new NotFoundException(env.getProperty("nodatafound"));
		}
		return curr;
	}
	
	@GetMapping(value = "/currency/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCurrencyNamesList() {
		List<String> curr = currencyService.getCurrencyNamesList();
		if (curr == null || curr.isEmpty()) {
			throw new NotFoundException(env.getProperty("nodatafound"));
		}
		return curr;
	}

	@GetMapping(value = "/currency/profit/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfitDetails getProfitDetails(@PathVariable String type) {
		ProfitDetails profit = currencyService.getProfitDetailsByType(type);
		if (profit == null) {
			throw new NotFoundException(env.getProperty("noprofitdatafound"));
		}
		return profit;
	}

	@PostMapping(value = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addCurrency(@RequestBody Currency currency) {
		currencyService.addCurrency(currency);
	}
	
	//------- Not Allowed--------------
	
	@GetMapping(value = "/currency/{type}/*")
    public void currencyGet() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, env.getProperty("badrequest"));
    }

	@GetMapping(value = "/currency/profit/{type}/*")
	public void currencyProfitGet() {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, env.getProperty("badrequest"));
	}
	
	@PutMapping(value = "/currency/*")
	public void currencyPut() {
		throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, env.getProperty("methodnotallowed"));
	}

    @PostMapping(value = "/currency/*")
    public void currencyPost() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, env.getProperty("methodnotallowed"));
    }

    @DeleteMapping(value = "/currency/*")
    public void currencyDelete() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, env.getProperty("methodnotallowed"));
    }
}