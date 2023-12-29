package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
    @FindBy (css = "[data-qa=\"login-email\"]")
    public WebElement loginEmailInbox;
    @FindBy (css = "[data-qa='login-password']")
    public WebElement loginPasswordInbox;
    @FindBy (css = "[data-qa=\"login-button\"]")
    public WebElement loginBtn;
    @FindBy (css = "[data-qa=\"signup-name\"]")
    public WebElement singUpNameInbox;
    @FindBy (css = "[data-qa=\"signup-email\"]")
    public WebElement signUpEmailInbox;
    @FindBy (css = "[data-qa=\"signup-button\"]")
    public WebElement signUpBtn;


    public void login(){
        loginEmailInbox.sendKeys(ConfigurationReader.get("email"));
        loginPasswordInbox.sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.clickWithJS(loginBtn);
    }

    public void signUp(String name, String email){
        singUpNameInbox.sendKeys(name);
        signUpEmailInbox.sendKeys(email);
        BrowserUtils.clickWithJS(signUpBtn);
    }
    public void verifyLoginAccountVisible(){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[.='Login to your account']")).isDisplayed());
    }
    public void verifyNewUserSignupVisible(){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[.='New User Signup!']")).isDisplayed());
    }
    public void verifyIncorrectLoginInput(){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[.='Your email or password is incorrect!']")).isDisplayed());
    }
    public void verifyEmailAlreadyExist(){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[.='Email Address already exist!']")).isDisplayed());
    }
}
