/**
 * 
 */
package com.abhishek.utility;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author abhishekashara
 *
 */
@Component
public class ValidationUtility {

	/**
	 * This method is used to c the size of stockList variable is greater than or
	 * equal to size passed
	 * 
	 * @param stockList
	 * @param maxsize
	 * @return
	 */
	public boolean valideStocks(List<String> stockList, int maxsize) {
		boolean isValide = false;
		if (stockList.size() <= maxsize) {
			isValide = true;
		}
		return isValide;
	}
}
