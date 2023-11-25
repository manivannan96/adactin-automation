package com.pages;



import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {
	

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Booked Itinerary")
	private WebElement bookIt;
	@FindBy(id = "order_id_text")
	private WebElement enterOrder;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement selectOrder;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement clickCancel;
	
	
@FindBy(id="search_result_error")
private WebElement BookingCancelMessage;

	public WebElement getBookingCancelMessage() {
	return BookingCancelMessage;
}

	public WebElement getBookIt() {
		return bookIt;
	}

	public WebElement getEnterOrder() {
		return enterOrder;
	}

	public WebElement getSelectOrder() {
		return selectOrder;
	}

	public WebElement getClickCancel() {
		return clickCancel;
	}

	public void cancelOrderId(String orderId) throws AWTException, InterruptedException {

		click(getBookIt());
		sendKeys(getEnterOrder(), orderId);
		robot();
		Thread.sleep(7000);
		click(getSelectOrder());
		click(getClickCancel());
		Thread.sleep(7000);
		accept();
		
	}
	}
	
	

