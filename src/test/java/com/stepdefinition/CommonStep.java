package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;


import io.cucumber.java.en.Then;


public class CommonStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String successMsg) {
		
		WebElement successMessage = pom.getSearchHotelPage().getSuccessMessage();
		String attribute = getAttribute(successMessage);
		System.out.println(attribute);
Assert.assertEquals("verifying message", attribute, successMsg);
	}

}
