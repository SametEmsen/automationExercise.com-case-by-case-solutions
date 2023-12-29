package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_04 extends TestBase{
    @Test
    public void test04_logoutUser() {
        HomePage homePage =new HomePage();
        LoginPage loginPage=new LoginPage();
        extentLogger= report.createTest("Test Case 4: Logout User");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Signup / Login' button");
        homePage.navigateToElement("Login");

        extentLogger.info("Verify 'Login to your account' is visible");
        loginPage.verifyLoginAccountVisible();

        extentLogger.info("logged in via correct inputs");
        loginPage.login();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        homePage.verifyLoggedIn();

        extentLogger.info("Click 'Logout' button");
        homePage.navigateToElement("Logout");

        extentLogger.info("Verify that user is navigated to login page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");

        extentLogger.pass("Passed..!!!");
    }
}
