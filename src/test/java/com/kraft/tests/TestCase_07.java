package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_07 extends TestBase{
    @Test
    public void test07_verifyTestCasePage() {
    HomePage homePage =new HomePage();

        extentLogger= report.createTest("Test Case 7: Verify Test Cases Page");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Test Cases' button");
        homePage.navigateToElement("Test Cases");
        BrowserUtils.waitFor(2);

        extentLogger.info("Verify user is navigated to test cases page successfully");
        String expectedUrl="https://automationexercise.com/test_cases";
        homePage.verifyPage(expectedUrl,"Test Cases");

        extentLogger.pass("Passed..!!!");
    }
}
