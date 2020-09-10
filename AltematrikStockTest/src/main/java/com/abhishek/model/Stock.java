/**
 * 
 */
package com.abhishek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author abhishekashra
 *
 */
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stockId")
	private int stockId;

	@Column(name = "quote")
	private String quote;

	@Column(name = "companyName")
	private String companyName;
	@Column(name = "date")
	private String date;
	@Column(name = "price")
	private double price;
	@Column(name = "currency")
	private String currency;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = Math.round(price * 100.0) / 100.0;
		;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Stock [quote=" + quote + ", companyName=" + companyName + ", date=" + date + ", price=" + price
				+ ", currency=" + currency + "]";
	}
}
