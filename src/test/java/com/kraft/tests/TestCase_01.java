package com.kraft.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import com.kraft.utilities.WebDriverFactory;

public class TestCase_01 {
    WebDriver driver=WebDriverFactory.getDriver("chrome");

    @Test
    public void test1() throws InterruptedException {
        /**
         *
         Test Case 1: Register User

         1. Launch browser
         2. Navigate to url "http://automationexercise.com"
         3. Verify that home page is visible successfully
         4. Click on 'Signup / Login' button
         5. Verify 'New User Signup!' is visible
         6. Enter name and email address
         7. Click 'Signup' button
         8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         9. Fill details: Title, Name, Email, Password, Date of birth
         10. Select checkbox 'Sign up for our newsletter!'
         11. Select checkbox 'Receive special offers from our partners!'
         12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
         13. Click 'Create Account button'
         14. Verify that 'ACCOUNT CREATED!' is visible
         15. Click 'Continue' button
         16. Verify that 'Logged in as username' is visible
         17. Click 'Delete Account' button
         18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


         */

        //1
        driver.get("http://automationexercise.com");
        //2
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        //3
        Thread.sleep(1000);

    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//i[@class='fa fa-lock']/..")).click();
        Thread.sleep(1000);
        //4
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        //5
        Assert.assertTrue(newUserSignup.isDisplayed());

        //6

    }

    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ahmet123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ahmet123@ahmet.com");
        Thread.sleep(1000);
        //7
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        Thread.sleep(1000);
        //8
        WebElement enterAccountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInformation.isDisplayed());

    }

    @Test
    public void test4() throws InterruptedException {
        //9
        driver.findElement(By.id("id_gender1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("123.asdf");
        Thread.sleep(1000);
        WebElement days = driver.findElement(By.id("days"));
        Select selectDays = new Select(days);
        selectDays.selectByValue("9");
        Thread.sleep(1000);
        WebElement months = driver.findElement(By.id("months"));
        Select selectMonths = new Select(months);
        selectMonths.selectByIndex(2);
        Thread.sleep(1000);
        WebElement years = driver.findElement(By.id("years"));
        Select selectYears = new Select(years);
        selectYears.selectByValue("2012");
        Thread.sleep(1000);
        //10
        driver.findElement(By.id("newsletter")).click();
        Thread.sleep(1000);
        //11
        driver.findElement(By.id("optin")).click();
        Thread.sleep(1000);
        //12
        List<WebElement> adressInformation = driver.findElements(By.cssSelector(":not([id=\"name\"]):not([id=\"email\"])[type=\"text\"]"));
        adressInformation.get(0).sendKeys("ahmet");
        adressInformation.get(1).sendKeys("oglu");
        adressInformation.get(2).sendKeys("sirket");
        adressInformation.get(3).sendKeys("bu adres");
        adressInformation.get(4).sendKeys("su adres");
        adressInformation.get(5).sendKeys("eyalet");
        adressInformation.get(6).sendKeys("ulke");
        adressInformation.get(7).sendKeys("45");
        adressInformation.get(8).sendKeys("0123");
        Thread.sleep(1000);

        WebElement dropdownCountry = driver.findElement(By.cssSelector("[id=\"country\"]"));
        Select selectCountry = new Select(dropdownCountry);
        selectCountry.selectByValue("Canada");
        Thread.sleep(1000);

        //13
        driver.findElement(By.cssSelector("[data-qa=\"create-account\"]")).click();
        //14
        WebElement accountCreatedText = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accountCreatedText.isDisplayed());

    }

    @Test
    public void test5() throws InterruptedException {
        //15
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Thread.sleep(1000);
        //16
        WebElement usernameLoggedIn = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(usernameLoggedIn.isDisplayed());

    }

    @Test @Ignore
    public void test6() throws InterruptedException {
        //17
        driver.findElement(By.xpath("//i[@class=\"fa fa-trash-o\"]/..")).click();
        Thread.sleep(1000);
        //18
        WebElement accountDeletedText = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accountDeletedText.isDisplayed());
        //19
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
