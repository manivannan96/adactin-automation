package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	Select select;

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location_span")
	private WebElement selectLocation;
	
	@FindBy(id = "checkin_span")
	private WebElement checkInError;

	@FindBy(id = "checkout_span")
	private WebElement checkOutError;

	@FindBy(id="username_show")
	private WebElement successMessage;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotel;

	@FindBy(id = "room_type")
	private WebElement roomType;
	@FindBy(id = "room_nos")
	private WebElement roomNos;
	@FindBy(id = "datepick_in")
	private WebElement dateIn;
	@FindBy(id = "datepick_out")
	private WebElement dateOut;
	@FindBy(id = "adult_room")
	private WebElement adults;
	@FindBy(id = "child_room")
	private WebElement childs;
	@FindBy(id = "Submit")
	private WebElement btnSearch;
	
	public WebElement getSelectLocation() {
		return selectLocation;
	}


	public WebElement getCheckInError() {
		return checkInError;
	}

	public WebElement getCheckOutError() {
		return checkOutError;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getDateIn() {
		return dateIn;
	}

	public WebElement getDateOut() {
		return dateOut;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getChilds() {
		return childs;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void searchHotels(String location, String hotels, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childsPerRoom) {
		WebElement loc = getLocation();
		selectByVisibleText(loc, location);

		WebElement hotel = getHotel();
		selectByVisibleText(hotel, hotels);

		WebElement type = getRoomType();
		selectByVisibleText(type, roomType);

		WebElement roomNos = getRoomNos();
		selectByVisibleText(roomNos, noOfRooms);

		WebElement inDate = getDateIn();
		click(inDate);
		clear(inDate);
		sendKeys(inDate, checkInDate);

		WebElement outDate = getDateOut();
		click(outDate);
		clear(outDate);
		sendKeys(outDate, checkOutDate);

		WebElement adults = getAdults();
		selectByVisibleText(adults, adultsPerRoom);

		WebElement childs = getChilds();
		selectByVisibleText(childs, childsPerRoom);

		WebElement searchBtn = getBtnSearch();
		click(searchBtn);
	}

	public void searchHotels(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		WebElement loc = getLocation();
		selectByVisibleText(loc, location);

		WebElement roomNos = getRoomNos();
		selectByVisibleText(roomNos, noOfRooms);

		WebElement inDate = getDateIn();
		click(inDate);
		clear(inDate);
		sendKeys(inDate, checkInDate);

		WebElement outDate = getDateOut();
		click(outDate);
		clear(outDate);
		sendKeys(outDate, checkOutDate);

		WebElement adults = getAdults();
		selectByVisibleText(adults, adultsPerRoom);

		WebElement searchBtn = getBtnSearch();
		click(searchBtn);
	}

	public void searchHotels() {
		WebElement searchBtn = getBtnSearch();
		click(searchBtn);
	}
}


