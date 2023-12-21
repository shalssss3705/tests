package com.demowebshop.test;

//Import statements for necessary TestNG and base class

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;

//PamentInfoPageTest class created , extending the BaseClass

public class PamentInfoPageTest extends BaseClass{

	@BeforeMethod

	public void beforeMethod() {

		test = extent.createTest("PamentInfoPageTest") ;

	}

	// Test method is created

	@Test(priority=8)

public void paymentInfoTestCase() {

		 // Calling the paymentInfo method from the PaymentInfoPage and assigning the result to confirmPage

	confirmPage = pamentInfoPage.paymentInfo();

	// Checking if the Confirm Order title is present on the page  by using assertion

	boolean isConfirmOrderTitlePresent = driver.findElement(By.xpath("//h2[text()=\"Confirm order\"]")).isDisplayed();

	Assert.assertTrue(isConfirmOrderTitlePresent);

	test.log(Status.INFO , "Click on the continue button");

	test.log(Status.PASS , " Sucessfully clicked on the continue button ");

}
 
	@AfterMethod

	public void afterMethod() {

		// Other teardown code...

		// Flush the ExtentReports instance

		extent.flush();

	}

}

