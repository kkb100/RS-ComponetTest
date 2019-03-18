package com.RSComponet.app.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    protected static WebDriver driver = null;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public DriverFactory(){

    }

    public static WebDriver BuildDriver(String browser){
        System.out.println("Iam building driver");
        switch(browser){
            case "chrome":
                return new ChromeDriver();
            case "ie":
                return new InternetExplorerDriver();
        }
        //Default returns chrome Driver
        return new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}