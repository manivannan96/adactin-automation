package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should enter {string},{string},{string},{string},{string},{string},{string},{string} and User should click on Search Box")
	public void user_should_enter_and_user_should_click_on_search_box(String location, String hotels, String roomType,
			String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childsPerRoom) {
		pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childsPerRoom);
	}

	@Then("User should verify after Search success message {string}")
	public void user_should_verify_after_search_success_message(String verifyselecthotel) {
		WebElement selecthotel = pom.getSelectHotelPage().getSelecthotel();
		String text = getText(selecthotel);
		boolean contains = text.contains(verifyselecthotel);
		Assert.assertTrue("verify after Search success message", contains);
	}

	@Then("User should enter only Mandatory field {string},,{string},{string},{string},{string} and User should click on Search Box")
	public void user_should_enter_only_mandatory_field_and_user_should_click_on_search_box(String location,
			String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotels(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@Then("User should verify after Search error message {string},{string}")
	public void user_should_verify_after_search_error_message(String CheckInError, String CheckOutError) {
		WebElement checkInError = pom.getSearchHotelPage().getCheckInError();
		String CheckIn = getText(checkInError);
		System.out.println(CheckIn);
		boolean contains = CheckIn.contains(CheckInError);
		Assert.assertTrue("verify after Search error message", contains);

		WebElement checkOutError = pom.getSearchHotelPage().getCheckOutError();
		String CheckOut = getText(checkOutError);
		System.out.println(CheckOut);
		boolean contains2 = CheckOut.contains(CheckOutError);
		Assert.assertTrue("verify after Search error message", contains2);

	}

	@Then("User should click on Search Box without enter any field and click on Search")
	public void user_should_click_on_search_box_without_enter_any_field_and_click_on_search() {
		pom.getSearchHotelPage().searchHotels();
	}

	@Then("User should verify after Search error message {string}")
	public void user_should_verify_after_search_error_message(String pleaseselectLoc) {
WebElement selectLocation = pom.getSearchHotelPage().getSelectLocation();
String text = selectLocation.getText();
boolean contains = text.contains(pleaseselectLoc);
Assert.assertTrue("verify after Search error message", contains);
	}

}