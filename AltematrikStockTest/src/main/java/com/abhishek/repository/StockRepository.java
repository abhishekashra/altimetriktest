/**
 * 
 */
package com.abhishek.repository;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.model.Stock;

/**
 * This is the Repository class to get the Stock by stockQuote and saving the
 * Stock
 * 
 * @author abhishekashra
 *
 */
public interface StockRepository extends CrudRepository<Stock, Integer> {
	Stock findByCurrency(String stockQuote);

	Stock save(Stock stock);

	Stock findByQuote(String stockQuote);
}
