package com.pages;


import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUser;
	@FindBy(id = "password")
	private WebElement txtPass;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(xpath="//b[contains(text(),'Invalid Login details')]")
	private WebElement errorMessage;

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String username, String password) {
		WebElement txtUserName = getTxtUser();
		sendKeys(txtUserName, username);

		WebElement txtPassword = getTxtPass();
		sendKeys(txtPassword, password);

		WebElement loginBtn = getBtnLogin();
		click(loginBtn);
	}

	public void loginWithEnterKey(String username, String password) throws AWTException {
		WebElement txtUserName = getTxtUser();
		sendKeys(txtUserName, username);

		WebElement txtPassword = getTxtPass();
		sendKeys(txtPassword, password);
		robot();

	}
}
