package com.mmk.util;

import java.util.ArrayList;
import java.util.List;

import com.mmk.entity.Currency;
import com.mmk.entity.ProfitDetails;

public class CurrencyUtil {
	public static ProfitDetails calculateProfitDetails(List<Currency> currencyList) {
		List<Currency> mins = new ArrayList<>();
		List<Currency> maxs = new ArrayList<>();

		if (currencyList != null && !currencyList.isEmpty()) {
			Currency currMin = currencyList.get(0);
			Currency currMax = currencyList.get(0);

			// Find all linear price increments and get min and max prices
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
		}

		System.out.println(mins);
		System.out.println(maxs);

		//No price data available
		if (maxs.size() == 0) {
			return null;
		}

		int maxProfitIndex = 0;
		double maxProfit = maxs.get(0).getPrice() - mins.get(0).getPrice();

		// Find profit for each increment
		for (int k = 1; k < mins.size(); k++) {
			double currProfit = maxs.get(k).getPrice() - mins.get(k).getPrice();
			if (currProfit > maxProfit) {
				maxProfitIndex = k;
				maxProfit = currProfit;
			}
		}

		Currency currSold = maxs.get(maxProfitIndex);
		Currency currBought = mins.get(maxProfitIndex);

		// Find any previous lower min value exists
		for (int k = 0; k < maxProfitIndex; k++) {
			if (mins.get(k).getPrice() < currBought.getPrice()) {
				currBought = mins.get(k);
			}
		}

		String profit = String.valueOf(currSold.getPrice() - currBought.getPrice());

		return new ProfitDetails(currSold.getCurrency(), String.valueOf(currBought.getPrice()), currBought.getTime(),
				String.valueOf(currSold.getPrice()), currSold.getTime(), profit);
	}
}
