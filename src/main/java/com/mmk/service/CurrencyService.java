package com.mmk.service;

import java.util.List;

import com.mmk.entity.Currency;
import com.mmk.entity.ProfitDetails;

public interface CurrencyService {
	public List<Currency> getCurrencyListByType(String type);

	public void addCurrency(Currency currency);

	ProfitDetails getProfitDetailsByType(String type);

	public List<String> getCurrencyNamesList();
}
