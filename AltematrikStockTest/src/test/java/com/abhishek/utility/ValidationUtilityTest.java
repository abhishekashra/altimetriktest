package com.abhishek.utility;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;

class ValidationUtilityTest {

	@Test
	void positive_testValideStocks() {
		ValidationUtility validationUtility = new ValidationUtility();
		List<String> stockList = new ArrayList<>();
		stockList.add("HDFC");
		stockList.add("HCL");
		stockList.add("ICICI");
		stockList.add("TANSOL");
		stockList.add("INFOSYS");
		boolean actual = validationUtility.valideStocks(stockList, 6);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

	@Test
	void negative_testValideStocks() {
		ValidationUtility validationUtility = new ValidationUtility();
		List<String> stockList = new ArrayList<>();
		stockList.add("HDFC");
		stockList.add("HCL");
		stockList.add("ICICI");
		stockList.add("TANSOL");
		stockList.add("INFOSYS");
		boolean actual = validationUtility.valideStocks(stockList, 4);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}

}
