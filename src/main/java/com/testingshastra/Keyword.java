package com.testingshastra;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.testingshastra.errors.InvalidBrowserError;

public class Keyword {

	public static RemoteWebDriver driver = null;
	public static FluentWait<WebDriver> wait = null;

	private static final Logger LOG = Logger.getLogger(Keyword.class);
	
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			LOG.info("Launched chrome browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			LOG.info("Launched firefox browser");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			LOG.info("Launched safari browser");
		} else {
			throw new InvalidBrowserError(browserName);
		}

		wait = new FluentWait<WebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery((Duration.ofMillis(500)));
		wait.ignoring(NoSuchElementException.class);
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void enterText(String locator, String textToEnter) {
		driver.findElement(By.xpath(locator)).sendKeys(textToEnter);
	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(textToEnter);
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	/**
	 * Use this method to click on {@code WebElement} by its xpath. This method
	 * doesn't support other locator strategies
	 * 
	 * @param locator
	 */
	public void clickOn(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	/**
	 * This method can be used to click on element. you need to provide locator-type
	 * and locator-value.
	 * 
	 * @param locatorType  that is one of following: id, name, tagname, classname,
	 *                     linktext etc
	 * @param locatorValue
	 */
	public void clickOn(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public WebElement waitForElementToBeVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}

	public WebElement waitForElementToBeVisible(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
