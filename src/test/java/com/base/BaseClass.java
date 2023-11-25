package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class BaseClass {
	public static WebDriver driver;

	public static String getfile() {
		String path = System.getProperty("user.dir");
		return path;

	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties"));
		System.out.println(properties);
		String value = (String) properties.get(key);
		return value;

	}

	public static void getDriver(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;

		}
	}

	// 1.WebDriver
	public static void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.
	public static void getUrl(String url) {
		driver.get(url);
	}

	// 3.
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// 4.
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 5.
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 6.
	public static void close() {
		driver.close();
	}

	// 7.
	public static void quit() {
		driver.quit();
	}

	// 8.
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	// 9.
	public static void navigateBack() {
		driver.navigate().back();
	}

	// 10.
	public static void navigateForward() {
		driver.navigate().forward();
	}

	// 11.
	public static void navigateRefresh() {
		driver.navigate().refresh();
		;
	}

	////////////////////////////////////////////////////////////////////////////
	public static WebElement findElement(String locator, String value) {
		WebElement element = null;
		switch (locator) {
		case "id":
			element = driver.findElement(By.id(value));
			break;
		case "name":
			element = driver.findElement(By.name(value));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;

		default:
			System.out.println("Invalid Locator");
			break;
		}
		return element;
	}

	// 12.WebElement
	public static WebElement findElementById(String id) {

		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	// 13.
	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 14.
	public static WebElement findElementByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	// 15.
	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 16.
	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	// 17.
	public static void clear(WebElement element) {
		element.clear();
	}

	// 18.
	public static void click(WebElement element) {
		element.click();
	}

	// 19.
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 20.
	public static String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	// 21.
	public static String getAttribute(WebElement element, String attributeName) {
		String text = element.getAttribute(attributeName);
		return text;
	}

	// 22.
	public static boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 23.
	public static boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 24.
	public static boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	//////////////////////////////////////////////////////////////////////////////////
	// 25.Actions
	static Actions ac;

	public static void actions() {
		Actions ac = new Actions(driver);
	}

	// 26.
	public static void moveToElement(WebElement element) {
		ac.moveToElement(element).perform();
	}

	// 27.
	public static void contextClick(WebElement element) {
		ac.contextClick(element).perform();
	}

	// 28.
	public static void doubleClick(WebElement element) {
		ac.doubleClick(element).perform();
	}

	// 29.
	public static void dragAndDrop(WebElement dragElement, WebElement dropElement) {
		ac.dragAndDrop(dragElement, dropElement).perform();
	}

	//////////////////////////////////////////////////////////////////////////////////
	// 30.Alert

	// 31.
	public static void accept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// 32.
	public static void dismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// 33.
	public static void sendKeysAlert(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}

	// 34.
	public static String getTextAlert() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 35.ScreenShot
	public static void Screenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File f = new File(path);
		FileUtils.copyFile(screenshot, f);
	}

	// 36.
	public static void ScreenshotLocation(WebElement element, String path) throws IOException {
		File screenshot = element.getScreenshotAs(OutputType.FILE);
		File f = new File(path);
		FileUtils.copyFile(screenshot, f);
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// 37.JavaScript Executor
	static JavascriptExecutor js;

	public static void setAttributeJs(WebElement element, String text) {
		js.executeScript("argumrnts[0].setAttribute('value','" + text + "')", element);
	}

	// 38.
	public static void clickJs(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	// 39.
	public static void getAttributeJs(WebElement element) {
		js.executeScript("arguments[0].getAttribute('value')", element);
	}

	// 40.
	public static void getAttributeJs(WebElement element, String attributeName) {
		js.executeScript("arguments[0].getAttribute('" + attributeName + "')", element);
	}

	// 41.
	public static void scrollIntoViewJs(WebElement element, boolean upOrDown) {
		js.executeScript("arguments[0].scrollIntoView(" + upOrDown + ")", element);
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// 42.DropDown
	public static void selectByIndex(WebElement element, int index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}

	// 43.
	public static void selectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	// 44.
	public static void selectByVisibleText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	// 45.
	public static void deSelectByIndex(WebElement element, int index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}

	// 46.
	public static void deSelectByValue(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	// 47.
	public static void deSelectByVisibleText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByValue(text);
	}

	// 48.
	public static void deSelectAll(WebElement element) {
		Select se = new Select(element);
		se.deselectAll();
	}

	// 49.
	public static WebElement getFirstSelectedOption(WebElement element) {
		Select se = new Select(element);
		WebElement firstSelectedOption = se.getFirstSelectedOption();
		return firstSelectedOption;
	}

	// 50.
	public static List<WebElement> getAllSelectedOption(WebElement element) {
		Select se = new Select(element);
		List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// 51.
	public static List<WebElement> getOptions(WebElement element) {
		Select se = new Select(element);
		List<WebElement> options = se.getOptions();
		return options;
	}

	// 52.
	public static boolean isMultiple(WebElement element) {
		Select se = new Select(element);
		boolean multiple = se.isMultiple();
		return multiple;
	}

	/////////////////////////////////////////////////////////////////////////////
	// 53.WebTable
	public static List<WebElement> findElementsByTagName(String tagName) {
		List<WebElement> elements = driver.findElements(By.id(tagName));
		return elements;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// 54.Windows Handling
	public static String getWindowHandle() {
		String windowId = driver.getWindowHandle();
		return windowId;

	}

	// 55.
	public static Set<String> getWindowsHandle() {
		Set<String> windowsId = driver.getWindowHandles();
		return windowsId;
	}

	// 56.
	public static void switchToWindow(String id) {
		driver.switchTo().window(id);
	}

	//////////////////////////////////////////////////////////////////////////////
	// 57.Frames
	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 58.
	public static void switchToFrameByAttribute(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 59.
	public static void switchToFrameByWebElement(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 60.
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// 61.
	public static void switchToWebDriver() {
		driver.switchTo().defaultContent();
	}

	public static void robot() throws AWTException {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	// 62.waits
	// Implicit Wait
	// public static void implicitWait() {
	// driver.manage().timeouts().implicitlyWait(56, Duration.ofSeconds(50));

	// }

	// 63.Explicit Wait
//	public static WebElement explicitWait(WebElement element) {
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	// WebElement elementForAction =
	// wait.until(ExpectedConditions.visibilityOf(element));
//		return elementForAction;
//	}

	// 64.FluentWait
	public static void fluentWait(long sec, long pollSec) {
		Wait wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(pollSec)).ignoring(Exception.class);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

}
