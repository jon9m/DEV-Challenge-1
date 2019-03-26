package com.mmk.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.mmk.entity.Currency;

public class TestUtil {
	private static final int MAX_VAL = 10000;
	private static DecimalFormat df = new DecimalFormat("#.00"); 

	public static List<Currency> generateCurrencyList() {

		List<Currency> currencyList = new ArrayList<>();
		for (int i = 0; i < MAX_VAL; i++) {
			double rand = Math.random() * 30;
			System.out.println(df.format(rand));
			currencyList.add(new Currency(1, "A", "123", "34", rand));
		}
		return currencyList;
	}
}
