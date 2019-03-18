package com.RSComponet.app.steps;

import com.RSComponet.app.Infrastructure.BrowserConfig.BrowserFactory;
import com.RSComponet.app.PageObject.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.RSComponet.app.PageObject.PageDomain.*;
import static org.junit.Assert.*;

public class CheckOutStepsDef {

//    private WebDriver driver;

//    CheckOutStepsDef(){
//        this.driver = BrowserFactory.getDriver();
//    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homepage.goToHomePage().goToLoginPage();
    }

    @And("I login into account")
    public void iLoginIntoAccount() {
        loginPage.doLogin();
//                try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @When("I checkout from the app")
    public void iCheckoutFromTheApp() {
        productSearch.SearchProduct("battery");
        productSearch.AddProductToBasket();
        productSearch.GoToBasketPage();
        basketPage.GoToDeliverypage();
        deliveryPage.GotoPaymentPage();

    }

    @Then("I am presented with make a payment")
    public void iAmPresentedWithMakeAPayment() {

        assertTrue("Validation of payment button is visible",paymentPage.isPaymentButtonPresent());

    }
}
