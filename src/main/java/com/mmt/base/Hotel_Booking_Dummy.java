package com.mmt.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hotel_Booking_Dummy extends Base_Class {

	public static void main(String[] args) throws Throwable {
		getBrowser("chrome");
		implicit_Wait();
		getUrl("https://www.makemytrip.com/");
		implicit_Wait();
//		driver.findElement(By.xpath("//label[text()='Login with Phone/Email']")).click();
//		driver.findElement(By.xpath("//input[@id='username']"));
		driver.findElement(By.xpath("//p[text()='Login or Create Account']")).click();
		// driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mohammedfazilsultan@gmail.com");
//		driver.findElement(By.xpath("//button//span")).click();
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Davidraj@mmt1998");
//		driver.findElement(By.xpath("//button//span")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mohammedfazilsultan@gmail.com");
		implicit_Wait();
		WebElement findElement = driver.findElement(By.xpath("//button[@data-cy='continueBtn']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		findElement.click();
		findElement.click();
		findElement.click();
		findElement.click();
		findElement.click();
		findElement.click();



         implicit_Wait();
		
		 driver.findElement(By.xpath("//a[text()='or Login via OTP']")).click();
		implicit_Wait();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button//span[text()='Login']")).click();
		implicit_Wait();

	}

}
