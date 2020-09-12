package com.testingshastra.Keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testingshastra.Constant.Constant;
import com.testingshastra.CustomUtils.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant {

	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;

		case "Firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;
		case "IE":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;
		default:
			break;

		}
	}

	public static void openUrl(String url) {
		driver.get(url);
	}

	public static void closeLoginPopup() {
		String closePopup = PropertiesUtil.getLocators("popupCloseButton");
		driver.findElement(By.xpath(closePopup)).click();
	}

	public static void searchProduct(String productName) {
		String searchComponent = PropertiesUtil.getLocators("searchComponent");
		driver.findElement(By.xpath(searchComponent)).sendKeys(productName);
		String magnifier = PropertiesUtil.getLocators("magnifier");
		driver.findElement(By.xpath(magnifier)).click();

	}

}
