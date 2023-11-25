package com.stepdefinition;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();

	@Then("User should Select a Hotel and Click on Continue")
	public void user_should_select_a_hotel_and_click_on_continue() {
pom.getSelectHotelPage().selectHotel();

	}

	@Then("User should verify after Continue Success message {string}")
	public void user_should_verify_after_continue_success_message(String BookHotel) {
		WebElement bookHotel2 = pom.getBookHotelPage().getBookHotel();
		String text = getText(bookHotel2);
		boolean contains = text.contains(BookHotel);
		Assert.assertTrue("verify after Continue Success message", contains);
	}

	@Then("User should Click on Continue without Selecting a Hotel")
	public void user_should_click_on_continue_without_selecting_a_hotel() {
pom.getSelectHotelPage().clickContinue();
	}

	@Then("User should verify after Continue Error message {string}")
	public void user_should_verify_after_continue_error_message(String PleaseSelect) {
WebElement pleaseSelectAHotel = pom.getSelectHotelPage().getSelectHotelErrorMessage();
String text = getText(pleaseSelectAHotel);
boolean contains = text.contains(PleaseSelect);
Assert.assertTrue("verify after Continue Error message", contains);
	}

}
