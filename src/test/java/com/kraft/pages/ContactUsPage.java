package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUsPage extends BasePage {
    @FindBy(css = "[name=\"name\"]")
    public WebElement nameInbox;
    @FindBy(css = "[name=\"email\"]")
    public WebElement emailInbox;
    @FindBy(css = "[name=\"subject\"]")
    public WebElement subjectInbox;
    @FindBy(css = "[name=\"message\"]")
    public WebElement messageInbox;
    @FindBy(css = "[name=\"submit\"]")
    public WebElement submitBtn;
    @FindBy(css = "[name=\"upload_file\"]")
    public WebElement chooseFileBtn;
    @FindBy (xpath = "(//div[@class=\"contact-form\"]/div)[2]")
    public WebElement successMessage;
    @FindBy(xpath = "//span[.=' Home']")
    public WebElement homeBtn;

    public void verifyGetInTouchVisible() {
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h2[.='Get In Touch']")).isDisplayed());

    }
    public void verifySuccessMessageVisible(){
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void fillForm(String name, String email, String subject, String message, String fileName) {
        nameInbox.sendKeys(name);
        emailInbox.sendKeys(email);
        subjectInbox.sendKeys(subject);
        messageInbox.sendKeys(message);

        String path = System.getProperty("user.dir")+"/"+"/src/test/resources/"+fileName;

        chooseFileBtn.sendKeys(path);
        submitBtn.click();
    }

}

