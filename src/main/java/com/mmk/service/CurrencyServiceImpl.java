package com.mmk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmk.dao.CurrencyDAO;
import com.mmk.entity.Currency;
import com.mmk.entity.ProfitDetails;
import com.mmk.util.CurrencyUtil;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDAO currencyDAO;

	@Override
	@Transactional
	public List<Currency> getCurrencyListByType(String type) {
		return currencyDAO.getCurrenyListByType(type);
	}

	@Override
	@Transactional
	public void addCurrency(Currency currency) {
		currencyDAO.addCurrency(currency);
	}

	@Override
	@Transactional
	public ProfitDetails getProfitDetailsByType(String type) {
		List<Currency> currencyList = getCurrencyListByType(type);

		// return the results
		return CurrencyUtil.calculateProfitDetails(currencyList);
	}

	@Override
	@Transactional
	public List<String> getCurrencyNamesList() {
		return currencyDAO.getCurrencyNamesList();
	}
}
