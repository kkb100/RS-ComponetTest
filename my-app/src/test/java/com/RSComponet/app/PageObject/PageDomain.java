package com.RSComponet.app.PageObject;
import org.openqa.selenium.WebDriver;

public class PageDomain {
    public WebDriver driver;

    public PageDomain(WebDriver driver){
        this.driver = driver;
    }
    public static HomePage homepage = null;
    public static ProductSearch productSearch = null;
    public static BasketPage basketPage = null;
    public static DeliveryPage deliveryPage = null;
    public static PaymentPage paymentPage = null;
    public static LoginPage loginPage = null;

    public void RegisterPageObjects(){
        homepage = new HomePage(driver);
        productSearch = new ProductSearch(driver);
        basketPage = new BasketPage(driver);
        deliveryPage = new DeliveryPage(driver);
        paymentPage = new PaymentPage(driver);
        loginPage = new LoginPage(driver);
    }
}
