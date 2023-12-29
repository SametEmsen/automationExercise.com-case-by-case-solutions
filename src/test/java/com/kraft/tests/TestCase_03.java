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

        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        homePage.navigateToElement("Login");
        loginPage.verifyLoginAccountVisible();

        loginPage.loginEmailInbox.sendKeys("email@email.com");
        loginPage.loginPasswordInbox.sendKeys("wrong password");
        loginPage.loginBtn.click();
        loginPage.verifyIncorrectLoginInput();
    }
}
