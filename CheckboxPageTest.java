package com.demowebshop.test;
 
import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;
 
public class CheckboxPageTest extends BaseClass {
 
    @BeforeMethod

    public void beforeMethod() {

        test = extent.createTest("CheckboxPageTest");

    }
 
    // Test method is created

    @Test(priority = 5, dataProvider = "checkboxTestData")

    public void checkboxTestCase(String company, String city, String address1, String address2, String postalCode,

            String phoneNumber, String faxNumber) {

        // Calling the checkbox method from the CheckboxPage and assigning the result to shippingAddressPage

        shippingAddressPage = checkboxPage.checkbox(company, city, address1, address2, postalCode, phoneNumber, faxNumber);
 
        // Checking if the Shipping Address title is present on the page by using assertion

        boolean isShippingAddressTitlePresent = driver.findElement(By.xpath("//h2[text()=\"Shipping address\"]"))

                .isDisplayed();

        Assert.assertTrue(isShippingAddressTitlePresent);
 
        test.log(Status.INFO, "Enter the credentials");

        test.log(Status.PASS, "Successfully entered the billing details");

    }
 
    // DataProvider method providing test data

    @DataProvider(name = "checkboxTestData")

    public Object[][] getCheckboxTestData() {

        return new Object[][] {

                { "xyz", "Scindia", "123 Street", "Apt 456", "12345", "1234567890", "9876543210" },

                // Add more test data sets as needed

        };

    }
 
    @AfterMethod

    public void afterMethod() {

        // Other teardown code...

        // Flush the ExtentReports instance

        extent.flush();

    }

}
