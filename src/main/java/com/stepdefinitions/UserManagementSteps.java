package com.stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.testingshastra.Keyword;
import com.testingshastra.pages.DashboardPage;
import com.testingshastra.pages.LoginPage;
import com.testingshastra.pages.PIMPage;
import com.testingshastra.pages.UserManagementPage;
import com.testingshastra.util.App;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementSteps {

	
	@And("User is logged into the system")
	public void loginToSystem() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		Thread.sleep(3000);
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLoginBtn();
	}
	@When("User clicks on PIM Menu")
	public void user_clicks_on_pim_menu() { //Snake Case
		DashboardPage dashboard = new DashboardPage();
		dashboard.waitForPimMenuToBeVisible();
		dashboard.clickOnPimMenu();
	}

	@And("Click on Add button")
	public void click_on_add_button() {
		DashboardPage dashboardPage = new DashboardPage();
		PIMPage pimpage = new PIMPage();
		pimpage.clickAddButton();
	}

	@And("Creates an user with valid details")
	public void creates_and_user_with_valid_details() {
		PIMPage pimpage = new PIMPage();
		pimpage.setFirstName("Subhash");
		pimpage.setMiddleName("Chandra");
		pimpage.setLastName("Bose");
		pimpage.clickOnSaveBtn();
	}

	@When("User clicks on Admin menue")
	public void user_clicks_on_admin_menue() {
		PIMPage pimpage = new PIMPage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickOnAdminMenu();
	}

	@And("Click on Add button on user management page")
	public void click_on_add_button_on_user_management_page() {
		UserManagementPage userMgmt = new UserManagementPage();
		userMgmt.clickOnAddBtn();
	}

	@When("User selects role as ESS")
	public void user_selects_role_as_ess() {
		UserManagementPage userMgmt = new UserManagementPage();
		userMgmt.selectRole("ESS");
	}

	@And("Enters employee name")
	public void enters_employee_name() throws InterruptedException {
		UserManagementPage userMgmt = new UserManagementPage();
		userMgmt.enterEmployeeName("Subhash");
	}

	@Then("Populated list must contain newly created users name")
	public void populated_list_must_contain_newly_created_user_s_name() {
		UserManagementPage userMgmt = new UserManagementPage();
		List<String> names = userMgmt.getEmployeeNames();
		Assert.assertTrue(names.contains("Subhash"));
	}


}
