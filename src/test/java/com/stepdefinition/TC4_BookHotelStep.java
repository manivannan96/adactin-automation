package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();

	@Then("User should Book Hotel {string},{string} and {string}")
	public void user_should_book_hotel_and(String firstname, String lastname, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> value =dataTable.asMaps();
		Map<String, String> key = value.get(1);
		String ccNum = key.get("Credit Card No");
		String ccType = key.get("Credit Card Type");
		String ccExpMonth = key.get("Select Month");
		String ccExpYear = key.get("Select Year");
		String cvv = key.get("CVV Number");
		
pom.getBookHotelPage().bookhotel(firstname, lastname, address, ccNum, ccType, ccExpMonth, ccExpYear, cvv);


	}

	@Then("User should verify after Booking Success message {string} and Save the Order Id")
	public void user_should_verify_after_booking_success_message_and_save_the_order_id(String string) throws InterruptedException {
String orderId = pom.getBookingConfirmPage().getOrderId();
System.out.println(orderId);
	}

	@Then("User should Click Book Now without filling any Fields")
	public void user_should_click_book_now_without_filling_any_fields() {
		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify Seven Error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_seven_error_messages_and(String FrstnamEr, String LstNamEr, String TxtAddEr,
			String CcNumEr, String CcTypEr, String CcExpMonthEr, String CvvEr) {
WebElement txtFirstName = pom.getBookHotelPage().getTxtFirstNameError();
String text = getText(txtFirstName);
boolean contains = text.contains(FrstnamEr);
Assert.assertTrue("verify one Error messages", contains);

WebElement txtLasttName = pom.getBookHotelPage().getTxtSecondNameError();
String text1 = getText(txtLasttName);
boolean contains1 = text1.contains(LstNamEr);
Assert.assertTrue("verify two Error messages", contains1);

WebElement TxtAddress = pom.getBookHotelPage().getAddressError();
String text2 = getText(TxtAddress);
boolean contains2 = text2.contains(TxtAddEr);
Assert.assertTrue("verify three Error messages", contains2);

WebElement CcNum = pom.getBookHotelPage().getCreditCardNoError();
String text3 = getText(CcNum);
boolean contains3 = text3.contains(CcNumEr);
Assert.assertTrue("verify four Error messages", contains3);

WebElement CcType = pom.getBookHotelPage().getCreditCardTypeError();
String text4 = getText(CcType);
boolean contains4 = text4.contains(CcTypEr);
Assert.assertTrue("verify five Error messages", contains4);

WebElement CcExpMonth = pom.getBookHotelPage().getExpiryDateError();
String text5 = getText(CcExpMonth);
boolean contains5 = text5.contains(CcExpMonthEr);
Assert.assertTrue("verify six Error messages", contains5);

WebElement Cvv = pom.getBookHotelPage().getCvvNumberError();
String text6 = getText(Cvv);
boolean contains6 = text6.contains(CvvEr);
Assert.assertTrue("verify Seven Error messages", contains6);

	}

}
