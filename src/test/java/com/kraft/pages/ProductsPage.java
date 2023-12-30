package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy (id = "search_product")
    public WebElement searchProductInbox;
    @FindBy(id = "submit_search")
    public WebElement searchBtn;
    @FindBy (xpath = "//*[.='Searched Products']")
    public WebElement searchedProductsText;
    @FindBy(xpath = "//a[contains(@href,'details')]")
    public List<WebElement> viewProductList;

    @FindBy (css = "[data-product-id='1']")
    public WebElement firstPruductAddToCartBtn;

    @FindBy(css = "[class=\"btn btn-success close-modal btn-block\"]")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//u[.='View Cart']")
    public WebElement viewCartBtn;

    public void viewProduct(String productName){
        WebElement element = Driver.get().findElement(By.xpath("//h2[.='" + productName + "']/ancestor::div[@class=\"product-image-wrapper\"]/div[@class=\"choose\"]"));
        BrowserUtils.clickWithJS(element);
    }
    public void searhProduct(String productName){
        searchProductInbox.sendKeys(productName);
        BrowserUtils.clickWithJS(searchBtn);

    }

    public void hoverAndClickChoosenProduct(int productNumber){
        WebElement element = Driver.get().findElement(By.xpath("(//a[@data-product-id="+productNumber+"])[1]"));
        BrowserUtils.hover(element);
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(element);

    }

}
