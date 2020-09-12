package com.goibib0.SearchFlight;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goibib0.Keyword.Keyword;

/**
 * To verify a message is displaying "Sorry, no flights available till 31st May
 * due to COVID-19 lockdown." after filling valid information for flight booking
 * and clicking on search buttonS
 * 
 * 
 * @author NRK
 *
 */
public class SearchFlight extends Keyword {
	
	@Test(description = "verify a message is displaying after filling valid information for flight booking after clicking on search button")
	public void searchFlight() {
		openBrowser("Chrome");
		maxWindow();
		implicitWait(10, "SECONDS");
		openUrl("https://www.goibibo.com/");
		enterText("from", "Mumbai");
		mouseHoverAndClick("citysource");
		enterText("to", "Delhi");
		mouseHoverAndClick("citydest");
		click("departure");
		click("todayDepartDate");
		click("search");
		explicitWait(2, "SECONDS");
		String actualMessage=getText("message");
		Assert.assertEquals(actualMessage, "Sorry, no flights available till 31st May due to COVID-19 lockdown.","Message not Matched!!");
		closeBrowser();
	}
}
