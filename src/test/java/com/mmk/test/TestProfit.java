package com.mmk.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestProfit {

	@SuppressWarnings("deprecation")
	@Test
	public void testProfit() {

		double[] prices = { 34.98, 36.13, 37.01, 35.98, 33.56 };
//		double[] prices = { 5,4,4,5,6,7,8,9,8,7,6,5,6,7,8,9,10,1,2 };

		List<Double> mins = new ArrayList<>();
		List<Double> maxs = new ArrayList<>();
		double currMin = prices[0];
		double currMax = prices[0];

		for (int j = 1; j < prices.length; j++) {
			if (prices[j] > currMax) {
				currMax = prices[j];
				if (j == prices.length - 1) {
					mins.add(currMin);
					maxs.add(currMax);
				}
			} else if ((prices[j] <= currMax)) {
				if (currMin != currMax) {
					mins.add(currMin);
					maxs.add(currMax);
				}
				currMin = prices[j];
				currMax = prices[j];
			}
		}
		
		assertTrue(mins.size() > 0);
		assertTrue(maxs.size() > 0);

//		System.out.println(mins);
//		System.out.println(maxs);

	}

}
