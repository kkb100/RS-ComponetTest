package com.RSComponet.app.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage {

    protected final WebDriver driver;

    @FindBy(id="checkoutSecurelyBtn")
    private WebElement CheckoutPaymentButton = null;


    public DeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void GotoPaymentPage() {
        if(driver.findElement(By.id("checkoutSecurelyBtn")).isDisplayed())
        driver.findElement(By.id("checkoutSecurelyBtn")).click();
    }

}
