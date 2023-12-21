package com.demowebshop.test;

//Import statements for necessary TestNG and base class

import java.io.File;

import java.io.IOException;
 
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;
 
// ThankyouPageTest class created , extending the BaseClass

public class ThankyouPageTest extends BaseClass{
 
	@BeforeMethod

	public void beforeMethod() {

		test = extent.createTest("ThankyouPageTest") ;

	}

	// Test method is created

	@Test(priority=10)

	// Register a new user and navigate through the order process

	public void thankyouTestCase() throws IOException, Throwable {

	    /*register1Page=registerPage.register("Betha" , "Naveena" , "Shalini678@gmail.com","Shalini888", "Shalini888");

	homePage=register1Page.registering();

		shoppingPage=homePage.books();

		checkboxPage=shoppingPage.shopping("123456");

		shippingAddressPage = checkboxPage.checkbox("xyz" ,"Scindia", "123 Street" ,"Apt 456", "12345", "1234567890", "9876543210");

		paymentPage = shippingAddressPage.shipping();

		pamentInfoPage=paymentPage.payment();

		confirmPage = pamentInfoPage.paymentInfo();

		thankyouPage =confirmPage.confirm();*/

		thankyouPage.thankyou();

		TakesScreenshot ts = (TakesScreenshot) driver;

		// Take a screenshot of the homepage after completing the order

        File src = ts.getScreenshotAs(OutputType.FILE);

        File trg = new File(".//screenshots//homepage.png");

        FileUtils.copyFile(src, trg);

        // Log test status to ExtentReports

		test.log(Status.INFO, "Input screenshots captured successfully"); 

        // Check if the  Demo Web Shop title is displayed on the page by using assertion

		boolean isDemoTitlePresent = driver.findElement(By.xpath("//img[@alt=\"Tricentis Demo Web Shop\"]")).isDisplayed();

		Assert.assertTrue(isDemoTitlePresent);

		test.log(Status.INFO , " Performaning all the functionalities");

		test.log(Status.PASS , " Sucessfully opened the  home page");

	}

		@AfterMethod

		public void afterMethod() {

			// Other teardown code...

			// Flush the ExtentReports instance

			extent.flush();

	}
 
}
