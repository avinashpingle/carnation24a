package com.testingshastra.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage {

	@FindBy(css = "div.orangehrm-header-container button")
	private WebElement addBtn;

	@FindBy(css = "div.oxd-select-text")
	private WebElement userRoleList;

	@FindBy(css = "div[role='listbox'] div>span")
	private List<WebElement> roleList;

	@FindBy(css = "input[placeholder=\"Type for hints...\"]")
	private WebElement employeeName;

	@FindBy(css = "div[role='listbox'] div>span")
	private List<WebElement> employeeNames;

	public void clickOnAddBtn() {
		addBtn.click();
	}

	public void clickOnUserRoleList() {
		userRoleList.click();
	}

	public void selectRole(String roleName) {
		for (WebElement role : roleList) {
			if (role.getText().equalsIgnoreCase(roleName)) {
				role.click();
				break;
			}
		}
	}

	public void enterEmployeeName(String employeeName) throws InterruptedException {
		this.employeeName.sendKeys(employeeName);
		Thread.sleep(3000);
	}

	public List<String> getEmployeeNames() {
		List<String> names = new ArrayList<String>();
		for (WebElement employeeName : employeeNames) {
			names.add(employeeName.getText());
		}
		return names;
	}

}
