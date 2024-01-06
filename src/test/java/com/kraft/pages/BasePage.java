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
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "footer")
    public WebElement footer;
    @FindBy(xpath = "//h2[.='Account Deleted!']")
    public WebElement accountDeletedText;

    /**
     * this method navigate to expected element name (!!case-sensitive)(e.g. "Cart","Products")
     *
     * @param elementName
     */
    public void navigateToElement(String elementName) {
        WebElement element = Driver.get().findElement(By.xpath("//a[contains(text(),'" + elementName + "')]"));
        BrowserUtils.clickWithJS(element);
    }

    public void verifyLoggedIn() {
        Assert.assertTrue(Driver.get().findElement(By.xpath("//a[contains(text(),'Logged')]")).isDisplayed());
    }

    /**
     * if there is an add pops-up this method refreshes the page
     * and navigate back to expected page via navigate Element name (e.g. "Cart","Products")
     * then assert the page is expected one
     *
     * @param url
     * @param navigatedElement
     */
    public void verifyPageViaElement(String url, String navigatedElement) {
        String actualPage = Driver.get().getCurrentUrl();
        String expectedPage = url;

        if (!actualPage.equals(expectedPage)) {
            Driver.get().navigate().refresh();
            navigateToElement(navigatedElement);
            actualPage = Driver.get().getCurrentUrl();
        }
        Assert.assertEquals(actualPage, expectedPage);
    }
    /**
     * if there is an add pops-up this method refreshes the page
     * and navigate back to expected page via expectedUrl
     * then assert the page is expected one
     *
     * @param url
     */
    public void verifyPageViaUrl(String url) {
        String actualPage = Driver.get().getCurrentUrl();
        String expectedPage = url;

        if (!actualPage.equals(expectedPage)) {
            Driver.get().navigate().refresh();
            Driver.get().navigate().to(expectedPage);
            actualPage = Driver.get().getCurrentUrl();
        }
        Assert.assertEquals(actualPage, expectedPage);
    }

    /**
     * verify products with listed items in for loop
     * if list is empty method gives us a message to consul
     */
    public void verifyProductInfoDisplayed() {
        List<WebElement> elementList = Driver.get().findElements(By.cssSelector("[cclass=\"product-information\"]>p,[class=\"product-information\"]>span,[class=\"product-information\"]>h2"));
        if (!(elementList.size() == 6)) {
            System.out.println("elementList.size() = " + elementList.size() + ",  check for locators");
            Assert.assertTrue(elementList.size()==6);       // for list is operational or not
        } else {
            for (WebElement element : elementList) {
                Assert.assertTrue(element.isDisplayed());
            }
        }
    }

    /***
     * this method assert that "ACCOUNT DELETED!" text is visible
     */
    public void verifyAccountDeleted() {
        Assert.assertTrue(accountDeletedText.isDisplayed());
    }

    public void closeAdd() {
        if (Driver.get().findElements(By.id("google_esf")).size() > 0) {
            Driver.get().switchTo().frame("google_esf");
            Driver.get().switchTo().frame("aswift_5");
            Driver.get().findElement(By.id("dismiss-button")).click();
        }
    }

}
