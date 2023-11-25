package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	@Given("User is on Adaction page")
	public void user_is_on_adaction_page() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();
	//	implicitymethod();

	}

	@When("User should perform Login {string},{string}")
	public void user_should_perform_login(String username, String password) {
pom.getLoginPage().login(username, password);
	}

	@When("User should perform Login {string},{string} by using Enter key")
	public void user_should_perform_login_by_using_enter_key(String username, String password) throws AWTException {
pom.getLoginPage().loginWithEnterKey(username, password);
	}

	@Then("User should verify after login with invalid credentials error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message_contains(String errorMessage) {
WebElement errorMsg = pom.getLoginPage().getErrorMessage();
String text = getText(errorMsg);
boolean b = text.contains(errorMessage);
Assert.assertTrue("Verify after login with invalid credentials error message",b);
	}

}
