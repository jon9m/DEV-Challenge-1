package com.mmk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "currency")
	private String currency;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "price")
	private double price;

	public Currency() {

	}

	public Currency(int id, String currency, String date, String time, double price) {
		super();
		this.id = id;
		this.currency = currency;
		this.date = date;
		this.time = time;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tid: " + id + "\n\tcurrency: " + currency + "\n\tdate: " + date
				+ "\n\ttime: " + time + "\n\tprice: " + price + "\n}";
	}

}
