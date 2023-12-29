package com.kraft.tests;

import com.kraft.pages.ContactUsPage;
import com.kraft.pages.HomePage;
import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_06 extends TestBase {
    @Test
    public void test06_contactUsForm() {
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();

        extentLogger = report.createTest("Test Case 6: Contact Us Form");
        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Contact Us' button");
        homePage.navigateToElement("Contact");

        extentLogger.info("Verify 'GET IN TOUCH' is visible");
        contactUsPage.verifyGetInTouchVisible();

        extentLogger.info("Enter name, email, subject, message and file");
        contactUsPage.fillForm(ConfigurationReader.get("name"), ConfigurationReader.get("email"),
                "Test cases", "Test cases study", "TestFile");

        extentLogger.info("Click OK button");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        extentLogger.info("Verify success message 'Success! Your details have been submitted successfully.' is visible");
        contactUsPage.verifySuccessMessageVisible();

        extentLogger.info("Click 'Home' button and verify that landed to home page successfully");
        contactUsPage.homeBtn.click();

        extentLogger.pass("Passed..!!!");
    }
}
