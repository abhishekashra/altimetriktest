package com.abhishek.model;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class StocksTest {

	@Test
	void testGetPrice() {
		Stock stock = new Stock();
		stock.setPrice(10000.12345);
		double actual = stock.getPrice();
		double expected = 10000.12;
		Assert.assertEquals(expected, actual);
	}

}
