package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.testingshastra.Keyword;
//SMEs => Subject Matter Expert

public class LoginPage {
	
	@FindBy(css = "input[name=\"username\"]")
	WebElement usernameTxtBx;
	
	@FindBy(css = "input[name=\"password\"]")
	WebElement passwordTxtBx;
	
	@FindBy(css = "button[type=\"submit\"]")
	WebElement loginBtn;
	
	
	
	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	public void enterUsername(String username) {
		usernameTxtBx.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtBx.sendKeys(password);
	}
	/*
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	*/
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public void waitForUsernameToBeVisible() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(usernameTxtBx);
	}
	
	
	
	
}
