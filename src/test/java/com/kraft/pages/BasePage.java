package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "footer")
    public WebElement footer;

    public void navigateToElement(String elementName){
        WebElement element = Driver.get().findElement(By.xpath("//a[contains(text(),'"+elementName+"')]"));
        BrowserUtils.clickWithJS(element);
    }
    public void verifyLoggedIn(){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//a[contains(text(),'Logged')]")).isDisplayed());
    }
    public void verifyPage(String url,String navigatedElement){
        String actualPage=Driver.get().getCurrentUrl();
        String expectedPage=url;

        if (!actualPage.equals(expectedPage)){
            Driver.get().navigate().refresh();
            navigateToElement(navigatedElement);
            actualPage=Driver.get().getCurrentUrl();
        }
            Assert.assertEquals(actualPage,expectedPage);
    }
    public void verifyProductInfoDisplayed(){        //BUNUN YERİ BURASI MI?
        List<WebElement> elementList = Driver.get().findElements(By.cssSelector("[class=\"product-information\"]>p,[class=\"product-information\"]>span,[class=\"product-information\"]>h2"));
        System.out.println("elementList.size() = " + elementList.size());
        for (WebElement element : elementList) {
            Assert.assertTrue(element.isDisplayed());
        }
    }



}
