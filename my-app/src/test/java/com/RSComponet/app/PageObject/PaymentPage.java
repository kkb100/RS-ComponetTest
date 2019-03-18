package com.RSComponet.app.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {

    protected final WebDriver driver;

    @FindBy(className="cssButton tertiary grey")
    private WebElement checkoutPaymentButton = null;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isPaymentButtonPresent(){
        return driver.findElement(By.id("checkoutSecurelyBtn")).isDisplayed();
    }
}
