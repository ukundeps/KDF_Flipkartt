package com.ajio.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;

public class Testcases extends Keyword {

	@BeforeTest
	public static void setUp() {
		openBrowser("chrome");
		maxWindow();
		openUrl("https://www.ajio.com/");
		implicitWait(20, "SECONDS");

	}

	@Test(description = "To verify Homepage title is displaying as \"Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO\"")
	public static void ajio_001() {
		Assert.assertEquals(getTitle(), "Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO",
				"Title mismatched!!");

	}

	@AfterTest
	public static void tearDown() {
		driver.close();
	}

}
