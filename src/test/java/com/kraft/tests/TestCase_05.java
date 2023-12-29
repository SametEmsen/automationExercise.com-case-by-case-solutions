package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_05 extends TestBase{
    @Test
    public void test05_registerUserWithExistingEmail() {
        HomePage homePage =new HomePage();
        LoginPage loginPage=new LoginPage();

        extentLogger= report.createTest("Test Case 5: Register User with existing email");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Signup / Login' button");
        homePage.navigateToElement("Login");

        extentLogger.info("Verify 'New User Signup!' is visible");
        loginPage.verifyNewUserSignupVisible();

        extentLogger.info(" Enter name and already registered email address");
        loginPage.singUpNameInbox.sendKeys("new user");
        loginPage.signUpEmailInbox.sendKeys(ConfigurationReader.get("email"));
        loginPage.signUpBtn.click();

        extentLogger.info("Verify error 'Email Address already exist!' is visible");
        loginPage.verifyEmailAlreadyExist();

        extentLogger.pass("Passed..!!!");

    }
}
