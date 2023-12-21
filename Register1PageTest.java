package com.demowebshop.test;
//Import statements for necessary TestNG and base class
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;
import com.demowebshop.base.BaseClass;
//RegisterPageTest class created , extending the BaseClass
public class Register1PageTest extends BaseClass {
	@BeforeMethod
	public void beforeMethod() {
		test = extent.createTest("Register1PageTest") ;
	}
	// Test method is created
	@Test(priority=2)
	public void registeringTestCase() {
		 // Calling the registering method from the Register1Page
	homePage=register1Page.registering();
	//comparing the expected url and actual url  by using assertion
		String expectedURL ="https://demowebshop.tricentis.com/";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		test.log(Status.INFO , "Enter the credentials");
		test.log(Status.PASS , " Clicking on registering button");
	}
	@AfterMethod
	public void afterMethod() {
		// Other teardown code...
		// Flush the ExtentReports instance
		extent.flush();
	}
}

