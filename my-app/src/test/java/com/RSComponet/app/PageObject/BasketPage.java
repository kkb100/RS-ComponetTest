package com.RSComponet.app.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage {

    protected final WebDriver driver;

    @FindBy(id="checkoutSecurelyAndPuchBtn")
    WebElement CheckoutPurchaseBtn = null;


    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }


    public void GoToDeliverypage() {
        if (driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).isDisplayed())
            driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).click();
    }

}
