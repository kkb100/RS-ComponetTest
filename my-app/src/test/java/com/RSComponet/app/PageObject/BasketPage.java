package com.RSComponet.app.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    protected final WebDriver driver;


    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }


    public void GoToDeliverypage() {
        if (driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).isDisplayed())
            driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).click();
    }

}
