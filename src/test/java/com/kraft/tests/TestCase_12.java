package com.kraft.tests;

import com.kraft.pages.HomePage;
import com.kraft.pages.ProductsPage;
import com.kraft.pages.ViewCartPage;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_12 extends TestBase{
    @Test
    public void test12_addProductsInCart() {

        HomePage homePage=new HomePage();
        ProductsPage productsPage=new ProductsPage();
        ViewCartPage viewCartPage=new ViewCartPage();

        extentLogger= report.createTest("Test Case 12: Add Products in Cart");

        extentLogger.info(" Navigate to url 'http://automationexercise.com'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        extentLogger.info("Click on 'Products' button");
        homePage.navigateToElement("Products");

        extentLogger.info("Hover over first product and click 'Add to cart'");
        productsPage.verifyPageViaElement("https://automationexercise.com/products","Products");
        BrowserUtils.waitFor(2);
        productsPage.hoverAndClickChoosenProduct(1);

        extentLogger.info("Click 'Continue Shopping' button");
        productsPage.continueShoppingBtn.click();

        extentLogger.info("Hover over second product and click 'Add to cart'");
        productsPage.hoverAndClickChoosenProduct(2);

        extentLogger.info("Click 'View Cart' button");
        productsPage.viewCartBtn.click();

        extentLogger.info("Verify both products are added to Cart");
        viewCartPage.verifyProductsInCart(2);

        extentLogger.info("Verify their prices, quantity and total price");
        viewCartPage.verifyCartPricesQuantitiesTotalsIsDisplayed();
    }
}
