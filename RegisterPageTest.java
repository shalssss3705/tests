package com.demowebshop.test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.demowebshop.base.BaseClass;
 
public class RegisterPageTest extends BaseClass {
 
    @BeforeMethod

    public void beforeMethod() {

        test = extent.createTest("RegisterPageTest");

    }
 
    // Test method is created

    @Test(priority = 1, dataProvider = "registrationData")

    public void registerTestCase(String firstName, String lastName, String email, String password, String confirmPassword) {

        // Calling the register method from the RegisterPage and assigning the result to register1Page

        register1Page = registerPage.register(firstName, lastName, email, password, confirmPassword);
 
        // comparing the expected url and actual url by using assertion

        String expectedURL = "https://demowebshop.tricentis.com/registerresult/1";

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
 
        test.log(Status.INFO, "Enter the credentials");

        test.log(Status.PASS, "Successfully clicked on the Register button");

    }
 
    // DataProvider method providing test data

    @DataProvider(name = "registrationData")

    public Object[][] getRegistrationData() {

        return new Object[][]{

                {"Betha", "Naveena", "oggy121@gmail.com", "qwerty33", "qwerty33"},

        };

    }
 
    @AfterMethod

    public void afterMethod() {

        // Other teardown code...

        // Flush the ExtentReports instance

        extent.flush();

    }

}
