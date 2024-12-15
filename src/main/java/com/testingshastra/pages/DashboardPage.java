package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.Keyword;

public class DashboardPage {

	@FindBy(css = "a[href*='PimMod']")
	WebElement pimMenu;
	
	@FindBy(css = "a[href*='AdminMod']")
	WebElement adminMenu;
	
	@FindBy(css = "a[href*='LeaveMod']")
	WebElement leaveMenu;
	
	
	public DashboardPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	public void clickOnPimMenu() {
		pimMenu.click();
	}
	
	public void waitForPimMenuToBeVisible() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(pimMenu);
	}
	public void clickOnAdminMenu() {
		adminMenu.click();
	}
}
