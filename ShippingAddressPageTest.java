package com.demowebshop.test;

//Import statements for necessary TestNG and base class

import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;

// ShippingAddressPageTest class created , extending the BaseClass

public class ShippingAddressPageTest extends BaseClass {

	@BeforeMethod

	public void beforeMethod() {

		test = extent.createTest("ShippingAddressPageTest") ;

	}

	// Test method is created

	@Test(priority=6)

	public void shippingTestCase() {

		// Setting implicit wait for 10 seconds to handle synchronization issues

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	paymentPage = shippingAddressPage.shipping();

	// Checking if the Payment Method title is present on the page by using assertion

	boolean isPaymentMethodTitlePresent = driver.findElement(By.xpath("//h2[text()=\"Payment method\"]")).isDisplayed();

	Assert.assertTrue(isPaymentMethodTitlePresent);

	test.log(Status.INFO , "Click on the checkbox button and continue button ");

	test.log(Status.PASS , " Sucessfully clicked on the checkbox button and  continue button ");

	}

	@AfterMethod

	public void afterMethod() {

		// Other teardown code...

		// Flush the ExtentReports instance

		extent.flush();

	}
 
}
