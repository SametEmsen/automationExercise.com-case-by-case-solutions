package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_03 extends TestBase {
    @Test
    public void test03_loginUserViaIncorrectEmail() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();

        extentLogger= report.createTest("Test Case 3: Login User with incorrect email and password");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info(" Click on 'Signup / Login' button");
        homePage.navigateToElement("Login");

        extentLogger.info("Verify 'Login to your account' is visible");
        loginPage.verifyLoginAccountVisible();

        extentLogger.info("Enter incorrect email address and password");
        loginPage.loginEmailInbox.sendKeys("email@email.com");
        loginPage.loginPasswordInbox.sendKeys("wrong password");

        extentLogger.info("Click 'login' button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify error 'Your email or password is incorrect!' is visible");
        loginPage.verifyIncorrectLoginInput();
    }
}
