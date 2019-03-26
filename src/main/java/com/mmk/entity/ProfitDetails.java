package com.mmk.entity;

public class ProfitDetails {
	private String currency;
	private String boughtPrice;
	private String boughtTime;
	private String soldPrice;
	private String soldTime;
	private String profit;

	public ProfitDetails() {
		super();
	}

	public ProfitDetails(String currency, String boughtPrice, String boughtTime, String soldPrice, String soldTime, String profit) {
		this.currency = currency;
		this.boughtPrice = boughtPrice;
		this.boughtTime = boughtTime;
		this.soldPrice = soldPrice;
		this.soldTime = soldTime;
		this.profit = profit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(String boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public String getBoughtTime() {
		return boughtTime;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public String getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(String soldPrice) {
		this.soldPrice = soldPrice;
	}

	public String getSoldTime() {
		return soldTime;
	}

	public void setSoldTime(String soldTime) {
		this.soldTime = soldTime;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tcurrency: " + currency + "\n\tboughtPrice: " + boughtPrice
				+ "\n\tboughtTime: " + boughtTime + "\n\tsoldPrice: " + soldPrice + "\n\tsoldTime: " + soldTime
				+ "\n\tprofit: " + profit + "\n}";
	}

}
