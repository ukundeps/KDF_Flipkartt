package com.ajio.keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.ajio.constant.Constant;
import com.goibib0.CustomUtil.CustomUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant{
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			break;

		}
		System.out.println(browserName + " is Opned!!");
	}

	/** This method will Maximize Browser Window **/

	public static void maxWindow() {
		driver.manage().window().maximize();
		System.out.println("Browser Window is maximized!! ");

	}

	/** This method will provide specified implicit wait to the driver instance **/

	public static void implicitWait(long duration, String Timeunit) {
		switch (Timeunit) {

		case "NANOSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MICROSECONDS);
			break;
		case "MILLISECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.DAYS);
			break;
		default:
			System.out.println(
					"please insert proper TimeUnit : Valid TimeUnits are-> SECONDS,MICROSECONDS,MILISECONDS,NANOSECONDS,MINUTES,HOURS,DAYS");

		}
		System.out.println(duration + Timeunit + " implicit wait is applied !!");

	}

	/** This Method will Open Specified URL **/

	public static void openUrl(String url) {
		driver.get(url);
		System.out.println(url + " is opened!!");
	}

	/** This method will close currently pointed browser window **/

	public static void closeBrowser() {
		driver.close();
		System.out.println("Currently pointed  Browser window  is closed!!");
	}

	/** This method will close browser window **/

	public static void closeAllBrowserWindow() {
		driver.quit();
		System.out.println(" All Browser Windows are closed!!");
	}

	/** This method will return the required WebEkement **/

	public static WebElement getWebElement(String locatorName) {
		System.out.println("Splitting  Locator " + locatorName);
		String locatorType = CustomUtil.getLocatorValue(locatorName)[0];
		String locatorValue = CustomUtil.getLocatorValue(locatorName)[1];
		System.out.println("locator type: " + locatorType);
		System.out.println("locator Value: " + locatorValue);

		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;

		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;

		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "className":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "partialLinktext":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		default:
			System.out.println("Locator Type is not Matching!!");
			break;

		}
		
		return element;

	}
/**
 * This method will return Title of current;y opened Website
 * @return
 */
	public static  String  getTitle() {
		return driver.getTitle();
	}
	
	
	/** This method will enter text in specified webelement **/

	public static void enterText(String element, String text) {
		getWebElement(element).sendKeys(text);
	}

	/** This method will click on specified webelement **/

	public static void click(String element) {
		getWebElement(element).click();
	}

	/** This method will hover mouse on webelement and click on it **/

	public static void mouseHoverAndClick(String element) {
		action=new Actions(driver);
		action.moveToElement(getWebElement(element)).click().build().perform();
	}

	/** This methdo will return text of Webelement **/

	public static String getText(String element) {
		return getWebElement(element).getText();

	}
/** This method will apply specified Explicite wait for specific action on webdriver instance **/
	
	public static void explicitWait(long duration, String Timeunit) {
		switch (Timeunit) {

		case "NANOSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MICROSECONDS);
			break;

		case "MILLISECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MILLISECONDS);
			break;

		case "SECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			wait.withTimeout(duration, TimeUnit.DAYS);
			break;
		default:
			System.out.println(
					"please insert proper TimeUnit : Valid TimeUnits are-> SECONDS,MICROSECONDS,MILISECONDS,NANOSECONDS,MINUTES,HOURS,DAYS");
		}
		System.out.println(duration + Timeunit + " explicite wait is applied !!");
	}


	public static void waitForVisibilityOfElement() {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
