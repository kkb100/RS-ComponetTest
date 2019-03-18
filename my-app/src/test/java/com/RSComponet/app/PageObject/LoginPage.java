package com.RSComponet.app.PageObject;

import com.RSComponet.app.Infrastructure.filereader.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    protected final WebDriver driver;

    @FindBy(name="username")
    private WebElement userName = null;

    @FindBy(name="j_password")
    private WebElement password = null;

    @FindBy(id="loginBtn")
    private WebElement logIn = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage doLogin(){
        driver.findElement(By.name("username")).sendKeys(ConfigReader.getObjectRepoValue("rscomponent.dev.login.userName"));
        driver.findElement(By.name("j_password")).sendKeys(ConfigReader.getObjectRepoValue("rscomponent.dev.login.password"));
        driver.findElement(By.name("loginBtn")).click();
        //logIn.click();
        return this;
    }

}
