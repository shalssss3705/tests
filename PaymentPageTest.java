package com.demowebshop.test;

//Import statements for necessary TestNG and base class

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;

// PaymentPageTest class created , extending the BaseClass

public class PaymentPageTest extends BaseClass {

	@BeforeMethod

	public void beforeMethod() {

		test = extent.createTest("PamentPageTest") ;

	}

	// Test method is created

	@Test(priority=7)

	public void paymentTestCase() {

		 // Calling the payment method from the PaymentPage and assigning the result to pamentInfoPage

		pamentInfoPage=paymentPage.payment();

		// Checking if the Payment Information title is present on the page  by using assertion

		boolean isPaymentInfoTitlePresent = driver.findElement(By.xpath("//h2[text()=\"Payment information\"]")).isDisplayed();

		Assert.assertTrue(isPaymentInfoTitlePresent);

		test.log(Status.INFO , "Click on the radio button and continue button ");

		test.log(Status.PASS , " Sucessfully clicked on the radio button and  continue button ");

	}

	@AfterMethod

	public void afterMethod() {

		// Other teardown code...

		// Flush the ExtentReports instance

		extent.flush();

	}

}
