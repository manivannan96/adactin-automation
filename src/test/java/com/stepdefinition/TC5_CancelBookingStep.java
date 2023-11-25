package com.stepdefinition;


import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	@Then("User Should cancel the current Order Id")
	public void user_should_cancel_the_current_order_id() throws AWTException, InterruptedException {
	    pom.getCancelBookingPage().cancelOrderId(pom.getBookingConfirmPage().getOrderId());
	}
	@Then("User Should verify After cancel Order Id success message {string}")
	public void user_should_verify_after_cancel_order_id_success_message(String OrderIdCancel) {
	 WebElement bookingCancelMessage = pom.getCancelBookingPage().getBookingCancelMessage();
	 String text = getText(bookingCancelMessage);
	 boolean contains = text.contains(OrderIdCancel);
	 Assert.assertTrue("verify After cancel Order Id success message", contains);
	}

	
	@Then("User Should cancel the Existing {string}")
	public void user_should_cancel_the_existing(String ExOrderId) throws AWTException, InterruptedException {
		pom.getCancelBookingPage().cancelOrderId(ExOrderId);
	}
	




}
