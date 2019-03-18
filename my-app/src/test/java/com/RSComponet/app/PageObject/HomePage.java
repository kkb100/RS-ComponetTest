package com.RSComponet.app.PageObject;

import com.RSComponet.app.Infrastructure.filereader.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    protected final WebDriver driver;

    @FindBy(id = "js-logInOut")
    protected WebElement logIn = null;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private HomePage prepareBrowser(){
        String baseUrl = ConfigReader.getObjectRepoValue("rscomponent.dev.base.url");
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);

        return this;
    }

    public HomePage goToHomePage(){
        this.prepareBrowser();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage goToLoginPage(){
        logIn.click();
        return this;
    }
}
