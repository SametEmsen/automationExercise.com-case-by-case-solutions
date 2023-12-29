package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(id = "footer")
    public WebElement footer;
    @FindBy(xpath = "//h2[.='Subscription']")
    public WebElement subscriptionTextElement;

    @FindBy (id = "susbscribe_email")
    public WebElement subscriptionInput;
    @FindBy(id = "subscribe")
    public WebElement subscribeBtn;
    @FindBy(xpath = "//div[.='You have been successfully subscribed!']")
    public WebElement successfullySubscMessageText;

    public void subscription(){
        subscriptionInput.sendKeys(ConfigurationReader.get("email"));
        BrowserUtils.clickWithJS(subscribeBtn);
    }
}
