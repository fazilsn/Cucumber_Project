package com.mmt.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	// static Variable

	public static WebDriver driver; // null driver

	// WebDriver Launch and Driver Manage Methods

	// Launch Browser

	public static void getBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

			// To Manage The Window Maximize()

			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

			// To Manage The Window Maximize()

			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase(" IE ")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			// To Manage The Window Maximize()

			driver.manage().window().maximize();
		}


	}
	// Close()

	public static void CloseOnWindow() {
		driver.close();
	}

	// Quit()

	public static void QuiteOnWindow() {
		driver.quit();
	}

	// WebDriver Methods

	// get Url()

	public static void getUrl(String url) {
		driver.get(url);
	}

	// getTitle()

	public static void getOnTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// getCurrentUrl()

	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// getPageSource

	public static void getPageSource() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	// Navigate Methods

	// Navigate to()

	public static void toUrl(String tourl) {

		driver.navigate().to(tourl);

	}

	// Navigate back()

	public static void backPage() {

		driver.navigate().back();

	}

	// Navigate forward()

	public static void forwardPage() {
		driver.navigate().forward();
	}

	// Navigate refresh()

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	// WebElement Methods

	// sendKeys()

	public static void inputValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	// click()

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	// getText()

	public static void getOnText(WebElement gettext) {

		String gettxt = gettext.getText();
		System.out.println(gettxt);
	}

	// getAttribute()

	public static void getOnAttribute(WebElement getattribute, String attributevalue) {

		String attribute = getattribute.getAttribute(attributevalue);
		System.out.println(attribute);

	}

	// isEnable()

	public static void isEnable(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}

	// isDisplayed()

	public static void isDisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

	}

	// isSelected()

	public static void isSelected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println(selected);

	}

	// Clear()

	public static void clearOnText(WebElement element) {

		element.clear();

	}

	// DropDown

	public static void dropDown(WebElement element, String value, String i) {

		Select s = new Select(element);
		if (value.equalsIgnoreCase("byvalue")) {

			s.selectByValue(i);

		} else if (value.equalsIgnoreCase("byvisibletext")) {
			s.selectByVisibleText(i);

		}

		else if (value.equalsIgnoreCase("byindex")) {

			int index = Integer.parseInt(i);
			s.selectByIndex(index);

		}

	}

	// de select DropDown

	public static void deSelectDropDown(WebElement element, String value, String i) {
		Select s = new Select(element);
		if (value.equalsIgnoreCase("byvalue")) {

			s.deselectByValue(i);

		} else if (value.equalsIgnoreCase("byvisibletext")) {
			s.deselectByVisibleText(i);

		}

		else if (value.equalsIgnoreCase("byindex")) {

			int index = Integer.parseInt(i);
			s.deselectByIndex(index);

		}

	}

	public static void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	// isMultiple()

	public static void IsMultiple(WebElement element) {

		Select ism = new Select(element);
		boolean multiple = ism.isMultiple();
		System.out.println(multiple);

	}

	// getOption()

	public static void GetOnOption(WebElement element) {

		Select gop = new Select(element);

		List<WebElement> options = gop.getOptions();

		for (WebElement getoption : options) {

			System.out.println(getoption.getText());

		}

	}

	// getAllSelectedOption()

	public static void GetAllSelectedOption(WebElement element) {

		Select gsaop = new Select(element);

		List<WebElement> allSelectedOptions = gsaop.getAllSelectedOptions();

		for (WebElement aso : allSelectedOptions) {

			System.out.println(aso.getText());

		}

	}

	// getFirstSelectedOption()

	public static void GetFirstSelectedOption(WebElement element) {

		Select gfsop = new Select(element);
		WebElement firstSelectedOption = gfsop.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());

	}

	// Alert

	public static void alertFunctions(WebElement element, String value, String input) {
		if (value.equalsIgnoreCase("accept")) {

			element.click();
			driver.switchTo().alert().accept();

		} else if (value.equalsIgnoreCase("dismiss")) {

			element.click();
			driver.switchTo().alert().dismiss();

		} else if (value.equalsIgnoreCase("sendkey")) {

			element.click();
			driver.switchTo().alert().sendKeys(input);
			driver.switchTo().alert().accept();

		}

	}

	// Actions
	public static void actionsMethods(WebElement element, String value) {

		Actions act = new Actions(driver);

		if (value.equalsIgnoreCase("click")) {

			act.click(element).build().perform();

		} else if (value.equalsIgnoreCase("doubleclick")) {

			act.doubleClick(element).build().perform();

		} else if (value.equalsIgnoreCase("rightClick")) {

			act.contextClick(element).build().perform();

		}

	}
	// dragAndDrop(WebElement Source, WebElement Target)

	public static void dragAndDrop(WebElement source, WebElement target) {

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();

	}

	// moveToElement()

	public static void moveToElement(WebElement to) {

		Actions act = new Actions(driver);
		act.moveToElement(to).build().perform();

	}

	// Robot() Right Click on WebPage Open A New Tab and New Window

	public static void robotMethod(WebElement element) throws AWTException {

		Actions act = new Actions(driver);

		act.contextClick(element).build().perform();

		Robot rob = new Robot();

		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

	}

	// Waits

	// Implicit Wait()

	public static void ImplicitWait(int w) {

		driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);

	}

	public static void sleep(long ms) throws InterruptedException {

		Thread.sleep(ms);

	}

	// TakesScreenshot

	public static void TakesScreenShot(String path) throws Throwable {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir") + "\\Screenshot\\Project" + path + ".png");
		FileUtils.copyFile(Source, Destination);

	}

	// Frames
	// index
	public static void FramesOnIndex(int index) {
		driver.switchTo().frame(index);

	}

	// id / name
	public static void FramesOnIdName(String frametype, String idornamevalue) {
		if (frametype.equalsIgnoreCase("Id")) {

			driver.switchTo().frame(idornamevalue);

		} else if (frametype.equalsIgnoreCase("Name")) {
			driver.switchTo().frame(idornamevalue);

		}

	}

	// WebElement
	public static void FramesOnWebelement(WebElement element) {
		driver.switchTo().frame(element);

	}

	// Close Frame
	public static void CloseTheFrame() {

		driver.switchTo().defaultContent();

	}

	// To Count No Of Frames In webPage

	public static void CountNoOfFrame(WebElement element) {
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("Total No Of Frames In The WebPage: " + size);
	}
		
		// Windows Handling
		
			// WindowHandle()

	public static void GetWindowHandle() {

		String windowHandle = driver.getWindowHandle();

		System.out.println(windowHandle);

		String title = driver.switchTo().window(windowHandle).getTitle();

		System.out.println(title);

	}

	//  WindowHandles()

	public static void GetWindowHandles() {

		Set<String> windowHandles = driver.getWindowHandles();

		for (String string : windowHandles) {

			System.out.println(string);

			String title = driver.switchTo().window(string).getTitle();

			System.out.println(title);

		}

	}
	
	//Window Handling when only two window present 
	public static void switchto_CurrentWindow() {
		String parentwindow = driver.getWindowHandle();
		System.out.println("parent Window id:" + parentwindow);

		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);

		for (String id : allid) {
			if (!(id.equals(parentwindow))) {
				driver.switchTo().window(id);

			}
		}

	}

	// Get Count Number Of The Windows

	public static void GetSizeOfWindow() {

		int size = driver.getWindowHandles().size();

		System.out.println("To Count Of Window : " + size);

	}
	
	//Scroll Down and Up
	
	public static void scrollfunction(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	public static void implicit_Wait() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
