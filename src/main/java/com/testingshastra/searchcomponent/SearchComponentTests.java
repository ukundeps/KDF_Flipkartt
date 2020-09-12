package com.testingshastra.searchcomponent;

import org.testng.annotations.Test;

import com.testingshastra.Keywords.Keyword;

public class SearchComponentTests {
	/**
	 * When User Applies price filter , then products with matching price must be appear
	 * @throws InterruptedException
	 */
	
	@Test(description="When User Applies price filter , then products with matching price must be appear")
	public void verifyPriceRange() throws InterruptedException {
		Keyword.openBrowser("Chrome");
		Keyword.openUrl("https://www.flipkart.com");
		Thread.sleep(5000);
		Keyword.closeLoginPopup();
		Keyword.searchProduct("Shoes");
		
	}

}
