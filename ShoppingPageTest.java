package com.demowebshop.test; 
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;
 
public class ShoppingPageTest extends BaseClass {
 
    @BeforeMethod

    public void beforeMethod() {

        test = extent.createTest("ShoppingPageTest");

    }
 
    // Test method is created

    @Test(priority = 4, dataProvider = "shoppingTestData")

    public void shoppingTestCase(String zipCode) {

        // Calling the shopping method from the ShoppingPage with the product code "123456"

        checkboxPage = shoppingPage.shopping(zipCode);
 
        // comparing the expected url and actual url by using assertion

        String expectedURL = "https://demowebshop.tricentis.com/onepagecheckout";

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
 
        test.log(Status.INFO, "Click on the shopping cart, estimate, checkbox, checkout buttons, sending zipcode ");

        test.log(Status.PASS, "Successfully all functionalities are performed done");

    }
 
    // DataProvider method providing test data

    @DataProvider(name = "shoppingTestData")

    public Object[][] getShoppingTestData() {

        return new Object[][] {

                { "12345" },

        };

    }
 
    @AfterMethod

    public void afterMethod() {

        // Other teardown code...

        // Flush the ExtentReports instance

        extent.flush();

    }

}
