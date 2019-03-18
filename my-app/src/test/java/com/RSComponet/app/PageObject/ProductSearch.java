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
        driver.findElement(By.xpath("(//DIV[text()='Add'])[1]")).click();
        return this;
    }

    public void GoToBasketPage() {
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//I[@class='icon-cart']")));
        if(driver.findElement(By.xpath("//I[@class='icon-cart']")).isDisplayed())
            driver.findElement(By.xpath("//I[@class='icon-cart']")).click();
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