package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement selecthotel;
	@FindBy(xpath = "//label[contains(text(),'Please Select a Hotel')]")
	private WebElement selectHotelErrorMessage;

	@FindBy(id = "radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id = "continue")
	private WebElement btnContinue;
	

	// getters

	public WebElement getSelecthotel() {
		return selecthotel;
	}
	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getSelectHotelErrorMessage() {
		return selectHotelErrorMessage;
	}

	public void selectHotel() {
		WebElement elementSelect = getBtnSelect();
		click(elementSelect);
		WebElement elementContinue = getBtnContinue();
		click(elementContinue);

	}

	public void clickContinue() {
		WebElement elementContinue = getBtnContinue();
		click(elementContinue);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


