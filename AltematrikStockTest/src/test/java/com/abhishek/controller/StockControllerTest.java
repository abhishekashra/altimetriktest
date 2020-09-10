package com.abhishek.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.abhishek.model.Stock;
import com.abhishek.repository.StockRepository;
import com.abhishek.utility.ValidationUtility;

import junit.framework.Assert;

@SpringBootTest
class StockControllerTest {

	@InjectMocks
	StockController stockController;

	@Mock
	StockRepository stockRepository;

	@Mock
	ValidationUtility validationUtility;

	@Test
	void positive_testgetStocks() {
		String str = "HDFC";
		Stock stock = new Stock();
		stock.setQuote(str);
		stock.setCompanyName("HDFC Bank");
		stock.setCurrency("INR");
		stock.setDate("2020-09-11");
		stock.setPrice(200.20);
		String[] stocks = str.split(",");
		List<String> stockQuotes = Arrays.asList(stocks);
		Mockito.when(validationUtility.valideStocks(stockQuotes, 10)).thenReturn(true);
		Mockito.when(stockRepository.findByQuote(str)).thenReturn(stock);
		String actual = stockController.getStocks(str);
		List<Stock> expected = new ArrayList<>();
		expected.add(stock);
		Assert.assertEquals(stock.toString(), actual);
	}

	@Test
	void negative_testgetStocks() {
		String str = "HDFC,RIL,ICICI,TANSOL,HUL,INFOSYS,WIPRO,HCL,IBM,GOOGLE,CITIUSTECH,TCS";
		Stock stock = new Stock();
		stock.setQuote(str);
		stock.setCompanyName("HDFC Bank");
		stock.setCurrency("INR");
		stock.setDate("2020-09-11");
		stock.setPrice(200.20);
		String[] stocks = str.split(",");
		List<String> stockQuotes = Arrays.asList(stocks);
		Mockito.when(validationUtility.valideStocks(stockQuotes, 10)).thenReturn(false);
		Mockito.when(stockRepository.findByQuote(str)).thenReturn(stock);
		String actual = stockController.getStocks(str);
		Assert.assertEquals("Maximum 10 stockQuotes allowed", actual);
	}
}
