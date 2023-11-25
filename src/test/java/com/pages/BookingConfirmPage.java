package com.pages;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.base.BaseClass;

	public class BookingConfirmPage extends BaseClass {
		

		public BookingConfirmPage() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//input[@id='order_no']")
		private WebElement orderNo;

		public WebElement getorderNo() {
			return orderNo;
		}

		public String getOrderId() throws InterruptedException {
			Thread.sleep(5000);
			WebElement orderNo = getorderNo();
			String orderID = getAttribute(orderNo);
			return orderID;
		}

	}
	
	
