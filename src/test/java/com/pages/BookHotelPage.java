package com.pages;



	

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// private webElement
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "address")
	private WebElement txtAddress;
	@FindBy(id = "cc_num")
	private WebElement ccNum;
	@FindBy(id = "cc_type")
	private WebElement ccType;
	@FindBy(id = "cc_exp_month")
	private WebElement ccExpMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement ccExpYear;
	
	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	@FindBy(id = "cc_cvv")
	private WebElement cvv;
	@FindBy(id = "book_now")
	private WebElement bookNow;

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement BookHotel;

	@FindBy(id = "first_name_span")
	private WebElement txtFirstNameError;

	@FindBy(id = "last_name_span")
	private WebElement txtSecondNameError;

	@FindBy(id = "address_span")
	private WebElement addressError;

	@FindBy(id = "cc_num_span")
	private WebElement creditCardNoError;

	@FindBy(id = "cc_type_span")
	private WebElement creditCardTypeError;

	@FindBy(id = "cc_expiry_span")
	private WebElement expiryDateError;

	@FindBy(id = "cc_cvv_span")
	private WebElement cvvNumberError;

	public WebElement getTxtFirstNameError() {
		return txtFirstNameError;
	}

	public WebElement getTxtSecondNameError() {
		return txtSecondNameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCreditCardNoError() {
		return creditCardNoError;
	}

	public WebElement getCreditCardTypeError() {
		return creditCardTypeError;
	}

	public WebElement getExpiryDateError() {
		return expiryDateError;
	}

	public WebElement getCvvNumberError() {
		return cvvNumberError;
	}

	public WebElement getBookHotel() {
		return BookHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public void bookhotel(String firstname, String lastname, String address, String ccNum, String ccType,
			String ccExpMonth, String ccExpYear, String cvv) {
		WebElement txtFirstName = getTxtFirstName();
		sendKeys(txtFirstName, firstname);
		WebElement txtLastName = getTxtLastName();
		sendKeys(txtLastName, lastname);
		WebElement txtAdress = getTxtAddress();
		sendKeys(txtAdress, address);
		WebElement txtccNum = getCcNum();
		sendKeys(txtccNum, ccNum);
		WebElement txtccType = getCcType();
		sendKeys(txtccType, ccType);
		WebElement txtccExpMonth = getCcExpMonth();
		sendKeys(txtccExpMonth, ccExpMonth);
		WebElement txtccExpYear=getCcExpYear();
		sendKeys(txtccExpYear,ccExpYear);
		WebElement txtCvv = getCvv();
		sendKeys(txtCvv, cvv);
		click(getBookNow());

	}

	public void bookHotel() {
		click(getBookNow());
	}
	
	
	
}
	

