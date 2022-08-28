package com.mmt.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mmt.base.Base_Class;
import com.mmt.runner.Test_Runner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.textui.TestRunner;

public class Step_Definition extends Base_Class {

	public static WebDriver driver = Test_Runner.driver;

	@Given("^user Launch the MakeMyTrip Application$")
	public void user_Launch_the_MakeMyTrip_Application() throws Throwable {
		getUrl("https://www.makemytrip.com/");
		implicit_Wait();
		Thread.sleep(5000);

	}

	@When("^user Clicks The Username In Login  Field and Username Tab Opens$")
	public void user_Clicks_The_Username_In_Login_Field_and_Username_Tab_Opens() throws Throwable {

	driver.findElement(By.xpath("//label[text()='Login with Phone/Email']")).click();
	implicit_Wait();
	}

//	@When("^user Enters The Username In Username Field$")
//	public void user_Enters_The_Username_In_Username_Field() throws Throwable {
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mohammedfazilsultan@gmail.com");
//		implicit_Wait();
//		Thread.sleep(1000);
//	}
//
//	@When("^user Clicks On Continue Button and It Navigates To Password Tab$")
//	public void user_Clicks_On_Continue_Button_and_It_Navigates_To_Password_Tab() throws Throwable {
//		WebElement findElement = driver.findElement(By.xpath("//span[text()='Continue']"));
//		findElement.click();
//		implicit_Wait();
//	}
//
//	@When("^user Enter The Password In Password Field$")
//	public void user_Enter_The_Password_In_Password_Field() throws Throwable {
//		implicit_Wait();
//		WebElement password = driver.findElement(By.xpath("//body//descendant::input[@id='password']"));
//		password.sendKeys("Davidraj@mmt1998");
//		implicit_Wait();
//	}
//
//	@Then("^user Click The Login Button and It Navigates To Home Page$")
//	public void user_Click_The_Login_Button_and_It_Navigates_To_Home_Page() throws Throwable {
//		driver.findElement(By.xpath("//span[text()='Login']")).click();
//		implicit_Wait();
//	}

	@When("^user Select The Hotel From The Navigation Catalogue$")
	public void user_Select_The_Hotel_From_The_Navigation_Catalogue() throws Throwable {
		WebElement to = driver.findElement(By.xpath("//li[@class='menu_Hotels']"));
		to.click();
		implicit_Wait();
	}

	@When("^user Select The Location Of The Hotel From The Available Location List$")
	public void user_Select_The_Location_Of_The_Hotel_From_The_Available_Location_List() throws Throwable {
//		driver.findElement(By.xpath("//input[@id='city']")).click();
		driver.findElement(By.xpath("//span[text()='City, Property name or Location']")).click();
		implicit_Wait();
		driver.findElement(
				By.xpath("//div//following::div[@class='spaceBetween makeFlex hrtlCenter'][2]//p[text()='Goa']"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("^user Enter The Check In Date In Check In Date Field$")
	public void user_Enter_The_Check_In_Date_In_Check_In_Date_Field() throws Throwable {
		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		implicit_Wait();
		driver.findElement(By.xpath("(//div//descendant::div/div[text()='28'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("^user Enter The Check Out Date In Check Out Date Field$")
	public void user_Enter_The_Check_Out_Date_In_Check_Out_Date_Field() throws Throwable {
		driver.findElement(By.xpath("(//div//descendant::div/div[text()='30'])[1]")).click();
		implicit_Wait();
	}

	@When("^user Select Number Of Adults Per Room$")
	public void user_Select_Number_Of_Adults_Per_Room() throws Throwable {
		driver.findElement(By.xpath("//div[@class='roomsGuests']//descendant::li[text()='2']")).click();
		implicit_Wait();
	}

	@When("^user Select Number Of Childrens Per Room$")
	public void user_Select_Number_Of_Childrens_Per_Room() throws Throwable {
		driver.findElement(By.xpath("//div//descendant::ul//following-sibling::ul//li[text()='1']")).click();
		WebElement ageofChildren = driver.findElement(By.xpath("//select[@class='ageSelectBox']"));

		dropDown(ageofChildren, "byindex", "8");
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApply']")).click();
		implicit_Wait();
	}

	@Then("^user Click The Search Button and It Navigates TO Select Hotel Page$")
	public void user_Click_The_Search_Button_and_It_Navigates_TO_Select_Hotel_Page() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		implicit_Wait();
	}

	@When("^user Click On The First Hotel In List Of Hotels Available$")
	public void user_Click_On_The_First_Hotel_In_List_Of_Hotels_Available() throws Throwable {
		driver.findElement(By.xpath("//div[@id='Listing_hotel_0']")).click();
		implicit_Wait();

	}

	@Then("^user  Navigates To Book the Hotel Page$")
	public void user_Navigates_To_Book_the_Hotel_Page() throws Throwable {
		switchto_CurrentWindow();
		driver.findElement(By.xpath("//button[text()='BOOK THIS NOW']"));
		

	}

}
