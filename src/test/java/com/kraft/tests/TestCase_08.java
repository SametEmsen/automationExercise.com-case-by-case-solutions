package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.ProductsPage;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_08 extends TestBase{
    @Test
    public void test08_verifyAllProductAndProductDetailPage() {
        HomePage homePage=new HomePage();
        ProductsPage productsPage=new ProductsPage();

        extentLogger= report.createTest("Test Case 8: Verify All Products and product detail page");
        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Products' button");
        homePage.navigateToElement("Products");

        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        String expectedUrl="https://automationexercise.com/products";
        homePage.verifyPageViaElement(expectedUrl,"Products");

        extentLogger.info("Click on 'View Product' of first product");
        productsPage.viewProductList.get(0).click();

        extentLogger.info("User is landed to product detail page");
        expectedUrl="https://automationexercise.com/product_details/1";
        productsPage.verifyPageViaUrl(expectedUrl);

        extentLogger.info("Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        productsPage.verifyProductInfoDisplayed();

        extentLogger.pass("Passed..!!!");
    }
}
