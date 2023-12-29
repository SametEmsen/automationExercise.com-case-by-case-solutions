package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.ProductsPage;
import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_09 extends TestBase{

    @Test
    public void test09_searchProduct() {
        HomePage homePage=new HomePage();
        ProductsPage productsPage=new ProductsPage();

        extentLogger= report.createTest("Test Case 9: Search Product");
        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Products' button");
        homePage.navigateToElement("Products");

        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        String expectedUrl="https://automationexercise.com/products";
        homePage.verifyPage(expectedUrl,"Products");

        extentLogger.info("Enter product name in search input and click search button");
        productsPage.searhProduct("Men Tshirt");

        extentLogger.info("Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertTrue(productsPage.searchedProductsText.isDisplayed());

        extentLogger.info(" Verify all the products related to search are visible");
        for (WebElement element : productsPage.viewProductList) {
            Assert.assertTrue(element.isDisplayed());
        }

        extentLogger.pass("Passed..!!!");
    }
}
