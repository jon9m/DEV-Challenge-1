package com.mmk.dao;

import java.util.List;

import com.mmk.entity.Currency;

public interface CurrencyDAO {

	public List<Currency> getCurrenyListByType(String type);

	public void addCurrency(Currency currency);

	public List<String> getCurrencyNamesList();

}
