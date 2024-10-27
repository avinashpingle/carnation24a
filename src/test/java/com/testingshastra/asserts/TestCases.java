package com.testingshastra.asserts;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {

	RemoteWebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	@Test
	public void verifyProductListWhenBrandFilterIsApplied() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("(//a[@href=\"/shop/women\"])[1]"));
		act.moveToElement(women).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class=\"desktop-backdropStyle\"]/descendant::a[contains(@href,'women') and contains(text(),'Dresses')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class=\"brand-list\"]/li[1]")).click();
		Thread.sleep(3000);
		List<WebElement> brandNames = driver.findElements(By.xpath("//h3[@class=\"product-brand\"]"));
		SoftAssert softly = new SoftAssert();
		for (int i = 0; i < brandNames.size(); i++) {
			String brandName = brandNames.get(i).getText();
			softly.assertEquals(brandName, "Trendyol");
		}
		
		softly.assertAll();
	}
}
