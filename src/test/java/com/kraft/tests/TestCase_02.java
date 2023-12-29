package com.kraft.tests;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_02 {
    WebDriver driver= WebDriverFactory.getDriver("chrome");

    /**
     *

     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter correct email address and password
     7. Click 'login' button
     8. Verify that 'Logged in as username' is visible
     9. Click 'Delete Account' button
     10. Verify that 'ACCOUNT DELETED!' is visible


     */
    @Test
    public void test02_loginViaCorrectInput() throws InterruptedException {
        driver.get("http://automationexercise.com");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://automationexercise.com/");

        WebElement signUp = driver.findElement(By.xpath("//i[@class='fa fa-lock']/.."));
        signUp.click();
        Thread.sleep(1000);

        WebElement text = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(text.isDisplayed());
        Thread.sleep(1000);

        WebElement emailInput = driver.findElement(By.cssSelector("[data-qa=\"login-email\"]"));
        emailInput.sendKeys("ahmet123@ahmet.com");
        Thread.sleep(1000);

        WebElement passInput = driver.findElement(By.cssSelector("[data-qa='login-password']"));
        passInput.sendKeys("123.asdf");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.cssSelector("[data-qa=\"login-button\"]"));
        loginBtn.click();
        Thread.sleep(1000);

        WebElement loggedText = driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]/.."));
        Assert.assertTrue(loggedText.isDisplayed());


    }
}
