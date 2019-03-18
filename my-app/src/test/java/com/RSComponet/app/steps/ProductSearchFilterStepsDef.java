package com.RSComponet.app.steps;

import com.RSComponet.app.PageObject.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.RSComponet.app.PageObject.PageDomain.productSearch;

public class ProductSearchFilterStepsDef {

//    private WebDriver driver;

//    ProductSearchFilterStepsDef(){
//        this.driver = DriverFactory.getDriver();
//    }


    @When("I search for product batteries$")
    public void iSearchForABatteryProduct() {
        productSearch.SearchProduct("batteries");
    }

    @Then("I validate product is displayed low to high")
    public void theProductIsSortedLowToHigh() {
        productSearch.sortByLowToHigh();
    }

    @Then("I validate product is displayed high to low")
    public void theProductIsSortedHighToLow() {
        productSearch.sortByHighToLow();
    }

}
