package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_02 extends TestBase {


    /**!!! Before this test case you must create an account manually for this task because
     * in the end you will delete this account!!!!
     *
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Signup / Login' button
     * 5. Verify 'Login to your account' is visible
     * 6. Enter correct email address and password
     * 7. Click 'login' button
     * 8. Verify that 'Logged in as username' is visible
     * 9. Click 'Delete Account' button
     * 10. Verify that 'ACCOUNT DELETED!' is visible
     */
    @Test
    public void test02_loginViaCorrectInput()  {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Test Case 2: Login User with correct email and password");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info(" Click on 'Signup / Login' button");
        homePage.navigateToElement("Login");

        extentLogger.info("Verify 'Login to your account' is visible");
        loginPage.verifyLoginAccountVisible();

        extentLogger.info("Enter correct email address and password");
        loginPage.loginEmailInbox.sendKeys(ConfigurationReader.get("email0"));
        loginPage.loginPasswordInbox.sendKeys(ConfigurationReader.get("password0"));

        extentLogger.info("Click 'login' button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        homePage.verifyLoggedIn();

        extentLogger.info("Click 'Delete Account' button");
        homePage.navigateToElement("Delete Account");

        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible");
        homePage.verifyPageViaElement("https://automationexercise.com/delete_account","Delete");
        homePage.verifyAccountDeleted();




    }
}
