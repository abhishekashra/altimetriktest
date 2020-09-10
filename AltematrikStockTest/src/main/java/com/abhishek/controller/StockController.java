/**
 * 
 */
package com.abhishek.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.model.ErrorMessage;
import com.abhishek.model.Stock;
import com.abhishek.repository.StockRepository;
import com.abhishek.utility.ValidationUtility;

/**
 * @author abhishekashra
 *
 */
@RestController
@RequestMapping(value = "/altematrik")
public class StockController {

	@Autowired
	ValidationUtility validationUtility;

	@Autowired
	StockRepository stockRepository;

	/**
	 * This method is used to save the Stock
	 * 
	 * @param stock
	 * @return
	 */
	@PostMapping(value = "/saveAllStock")
	public Stock saveStocks(Stock stock) {
		return stockRepository.save(stock);
	}

	/**
	 * This is the rest end point to check if the stocks are available if the it
	 * available then return the Stocks
	 * 
	 * @param stockQuote
	 * @return
	 */
	@GetMapping("/stockQuote")
	public String getStocks(@PathParam("stockQuote") String stockQuote) {
		String[] stocks = stockQuote.split(",");
		StringBuilder output = new StringBuilder();
		List<String> stockQuotes = Arrays.asList(stocks);
		List<Stock> stockList = new ArrayList<>();
		if (validationUtility.valideStocks(stockQuotes, 10)) {
			for (String stockName : stockQuotes) {
				Stock s = stockRepository.findByQuote(stockName);
				if(s!=null) {
					stockList.add(s);
					output.append(s.toString());
				}else {
					output.append("\n").append(stockName+" is not available");
					
				}
			}
		} else {
			output.append("Maximum 10 stockQuotes allowed");
		}
		
		 
		return output.toString() ;
	}
}
