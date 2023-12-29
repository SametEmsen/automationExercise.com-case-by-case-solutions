package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_10 extends TestBase{
    @Test
    public void test10_verifySubscriptionInHomePage() {
        HomePage homePage=new HomePage();

        extentLogger= report.createTest("Test Case 10: Verify Subscription in home page");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Scroll down to footer");
        BrowserUtils.scrollToElement(homePage.footer);

        extentLogger.info("Verify text 'SUBSCRIPTION'");
        String expectedText="SUBSCRIPTION";
        Assert.assertEquals(homePage.subscriptionTextElement.getText(),expectedText);

        extentLogger.info("Enter email address in input and click arrow button");
        homePage.subscription();

        extentLogger.info("Verify success message 'You have been successfully subscribed!' is visible");
        Assert.assertTrue(homePage.successfullySubscMessageText.isDisplayed());

        extentLogger.pass("Passed..!!!");

    }
}
