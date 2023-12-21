package com.demowebshop.test;

//Import statements for necessary TestNG and base class

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;

//HomePageTest class created , extending the BaseClass

public class HomePageTest extends BaseClass {

	@BeforeMethod

	public void beforeMethod() {

		test = extent.createTest("HomePageTest ") ;

	}

	// Test method is created

	@Test(priority=3)

	public void booksTestCase() throws InterruptedException {

		// Creating an instance of the HomePage using the WebDriver from the BaseClass

		 // Navigating to the books page and assigning the result to the shoppingPage

		shoppingPage=homePage.books();

		//comparing the urls  by using assertion

		String expectedURL ="https://demowebshop.tricentis.com/books";

		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(expectedURL, actualURL);

		test.log(Status.INFO , "Click on the bo0ks button and Add to cart button");

		test.log(Status.PASS , " Sucessfully clicked on the buttons ");

	}

	@AfterMethod

	public void afterMethod() {

		// Other teardown code...

		// Flush the ExtentReports instance

		extent.flush();

	}

}
