package com.mmk.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mmk.entity.Currency;
import com.mmk.entity.ProfitDetails;
import com.mmk.util.CurrencyUtil;

public class TestProfit2 {

	@Test
	public void testCalculateProfitDdetails() {
		List currencyList = new ArrayList<>();
		currencyList.add(new Currency(1, "A", "123", "34", 5));
		currencyList.add(new Currency(1, "A", "123", "34", 4));
		currencyList.add(new Currency(1, "A", "123", "34", 4));
		currencyList.add(new Currency(1, "A", "123", "34", 5));
		currencyList.add(new Currency(1, "A", "123", "34", 6));
		currencyList.add(new Currency(1, "A", "123", "34", 7));
		currencyList.add(new Currency(1, "A", "123", "34", 8));
		currencyList.add(new Currency(1, "A", "123", "34", 9));
		currencyList.add(new Currency(1, "A", "123", "34", 8));
		currencyList.add(new Currency(1, "A", "123", "34", 7));
		currencyList.add(new Currency(1, "A", "123", "34", 6));
		currencyList.add(new Currency(1, "A", "123", "34", 5));
		currencyList.add(new Currency(1, "A", "123", "34", 6));
		currencyList.add(new Currency(1, "A", "123", "34", 7));
		currencyList.add(new Currency(1, "A", "123", "34", 8));
		currencyList.add(new Currency(1, "A", "123", "34", 9));
		currencyList.add(new Currency(1, "A", "123", "34", 10));
		currencyList.add(new Currency(1, "A", "123", "34", 1));
		currencyList.add(new Currency(1, "A", "123", "34", 2));

		ProfitDetails profitDtl = CurrencyUtil.calculateProfitDetails(currencyList);

		assertNotNull(profitDtl);
		assertEquals(profitDtl.getProfit(), "5.0");
	}

	@Test
	public void testCurrencyList() {

		List<Currency> currencyList = new ArrayList<>();
//		currencyList.add(new Currency(1, "A", "123", "34", 34.98));
//		currencyList.add(new Currency(1, "A", "123", "34", 36.13));
//		currencyList.add(new Currency(1, "A", "123", "34", 37.01));
//		currencyList.add(new Currency(1, "A", "123", "34", 35.98));
//		currencyList.add(new Currency(1, "A", "123", "34", 33.56));

		currencyList = TestUtil.generateCurrencyList();

		// 5,4,4,5,6,7,8,9,8,7,6,5,6,7,8,9,10,1,2

		List<Currency> mins = new ArrayList<>();
		List<Currency> maxs = new ArrayList<>();
		Currency currMin = currencyList.get(0);
		Currency currMax = currencyList.get(0);

		for (int j = 1; j < currencyList.size(); j++) {
			if (currencyList.get(j).getPrice() > currMax.getPrice()) {
				currMax = currencyList.get(j);
				if (j == currencyList.size() - 1) {
					mins.add(currMin);
					maxs.add(currMax);
				}
			} else if ((currencyList.get(j).getPrice() <= currMax.getPrice())) {
				if (currMin.getPrice() != currMax.getPrice()) {
					mins.add(currMin);
					maxs.add(currMax);
				}
				currMin = currencyList.get(j);
				currMax = currencyList.get(j);
			}
		}

		System.out.println(mins);
		System.out.println(maxs);

		double[] profits = new double[mins.size()];
		int maxProfitIndex = 0;
		double maxProfit = maxs.get(0).getPrice() - mins.get(0).getPrice();
		for (int k = 1; k < mins.size(); k++) {
			double currProfit = maxs.get(k).getPrice() - mins.get(k).getPrice();
			if (currProfit > maxProfit) {
				maxProfitIndex = k;
				maxProfit = currProfit;
			}
		}

		// Find any previous lower min value exists
		int lowestIndex = maxProfitIndex;
		for (int k = 0; k < maxProfitIndex; k++) {
			if (mins.get(k).getPrice() < mins.get(maxProfitIndex).getPrice()) {
				lowestIndex = k;
			}
		}

		maxProfit = maxs.get(maxProfitIndex).getPrice() - mins.get(lowestIndex).getPrice();

		assertNotNull(maxProfitIndex);
		assertNotNull(maxProfit);

		System.out.println("Max profit ================ " + maxProfit);
		System.out.println("Max profit index ================ " + maxProfitIndex);
		
		System.out.println("Max Price dtl ================ " + maxs.get(maxProfitIndex));
		System.out.println("Min Price dtl ================ " + mins.get(lowestIndex));
	}

}
