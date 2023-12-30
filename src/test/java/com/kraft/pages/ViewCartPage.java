package com.kraft.pages;

import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ViewCartPage extends BasePage {

    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> productsInCartList;
    @FindBy(css = ".cart_price,.cart_quantity,.cart_total")
    public List<WebElement> cartPricesQuantitiesTotalsList;
    public int productsInCart(){
       return productsInCartList.size();
    }

    public void verifyProductsInCart(int productsSize){
        Assert.assertEquals(productsInCart(),productsSize);
    }
    public void verifyCartPricesQuantitiesTotalsIsDisplayed(){
        for (WebElement element : productsInCartList) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
