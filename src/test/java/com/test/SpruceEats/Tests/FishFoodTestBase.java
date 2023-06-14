package com.test.SpruceEats.Tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FishFoodTestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");


    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.GetScreenShot(driver, "blazePictures");
        }
        driver.quit();
    }
}

