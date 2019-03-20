package com.RSComponet.app.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearch {

    protected final WebDriver driver;

//    @FindBy(id="searchTerm")
//    WebElement searchText = null;
//
//    @FindBy(id="searchTerm")
//    WebElement searchButton = null;
//
//    @FindBy(id = "atbBtn-1")
//    WebElement addProductToBasket = null;
//
//    @FindBy(id = "js-basketQty")
//    WebElement viewBasketPage = null;



    public ProductSearch(WebDriver driver) {
        this.driver = driver;
    }

    public ProductSearch SearchProduct(String searchKeyWord){
        driver.findElement(By.id("searchTerm")).sendKeys(searchKeyWord);
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
        return this;
    }

    public ProductSearch AddProductToBasket(){
        driver.findElement(By.cssSelector("button[data-qa='add-to-basket-btn']")).click();
        return this;
    }

    public void GoToBasketPage() {
        String cssLocator = "div[class='shBasket js-basket']>a[href*='basketsummary']";
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
        if(driver.findElement(By.cssSelector(cssLocator)).isDisplayed())
            driver.findElement(By.cssSelector(cssLocator)).click();
    }

    public ProductSearch sortByLowToHigh(){
        driver.findElement(By.xpath("(//SPAN[text()='Relevance'])[1]")).isDisplayed();
        driver.findElement(By.xpath("(//SPAN[text()='Relevance'])[1]")).click();
        driver.findElement(By.xpath("//LI[@data-value='price_asc'][text()='Price: Low to High']")).click();
        return this;
    }

    public ProductSearch sortByHighToLow(){
        driver.findElement(By.xpath("(//SPAN[text()='Relevance'])[1]")).isDisplayed();
        driver.findElement(By.xpath("(//SPAN[text()='Relevance'])[1]")).click();
        driver.findElement(By.xpath("//LI[@data-value='price_desc'][text()='Price: High to Low']")).click();
        return this;
    }

}