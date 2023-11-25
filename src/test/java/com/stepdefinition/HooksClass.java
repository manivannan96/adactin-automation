package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	@Before

	public void beforescenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();

	}

	@AfterClass
	public void afterscenario(Scenario scenario) {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(b, "image/png", "Every Scenario");
//		driver.quit();


	if (scenario.equals(scenario)) {
		
		scenario.attach(screenshot(), "image/png", "every scenario");
		
		
	}
	
	
	 
	
	}


}
