package com.mmt.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mmt.base.Base_Class;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\mmt\\feature\\HotetBooking.feature",glue="com.mmt.stepdefinition")

public class Test_Runner extends Base_Class {
	//public static WebDriver driver;
	@BeforeClass
	public static void set_Up() {
		getBrowser("Chrome");
		
	}
//	@AfterClass
//	public static void tear_Down() {
//		driver.close();
//		
//	}
	

}