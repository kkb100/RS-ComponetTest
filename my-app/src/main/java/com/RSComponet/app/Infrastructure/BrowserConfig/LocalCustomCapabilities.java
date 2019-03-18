package com.RSComponet.app.Infrastructure.BrowserConfig;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import static com.RSComponet.app.Infrastructure.BrowserConfig.BrowserFactory.driver;


public class LocalCustomCapabilities {


    public WebDriver getFirefoxDriver(String machineType) throws IllegalAccessException {
        String firefoxPath = new LocalDriverPath().getFirefoxDriverPath(machineType);
        System.setProperty("webdriver.gecko.driver", firefoxPath);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        //profile.setEnableNativeEvents(true);
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability(FirefoxDriver.PROFILE, profile);
        caps.setJavascriptEnabled(true);
        caps.setCapability("marionette", true);
        return new FirefoxDriver(caps);
    }


    public WebDriver getIEDriver(String machineType) throws IllegalAccessException {
        String iePath = new LocalDriverPath().getInternetExplorerDriverPath(machineType);
        System.setProperty("webdriver.ie.driver", iePath);
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setJavascriptEnabled(true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        return new InternetExplorerDriver(caps);
    }


    public WebDriver getChromeDriver(String machineType) throws IllegalAccessException {
        String chromePath = new LocalDriverPath().getChromeDriverPath(machineType);
        System.setProperty("webdriver.chrome.driver", chromePath);
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("--enable-javascript");
        return new ChromeDriver(chromeOptions);
    }


//    public WebDriver getPhantonJsDriver(String machineType) throws IllegalAccessException {
//        String phantomjsPath = new LocalDriverPath().getPhantomJsDriverPath(machineType);
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        String execPath = PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY;
//        caps.setCapability(execPath, phantomjsPath);
//        return new PhantomJSDriver(caps);
//    }

    public WebDriver getHtmlChromeUnitDriver(String browserName){
        if(browserName.toLowerCase().contains("chrome")){
            driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }else if(browserName.toLowerCase().contains("chrome")) {
            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        }else if(browserName.toLowerCase().contains("chrome")) {
            driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11);
        }
        ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
        return driver;
    }

    public WebDriver getMicrosoftEdgeDriver(String machineType) throws IllegalAccessException {
        String micosoftEdgePath = new LocalDriverPath().getEdgeDriverPath(machineType);
        System.setProperty("webdriver.edge.driver", micosoftEdgePath);
        DesiredCapabilities caps = DesiredCapabilities.edge();
        caps.setJavascriptEnabled(true);
        caps.setPlatform(Platform.WIN10);
        return new EdgeDriver(caps);
    }

    public WebDriver getSafariDriver() throws IllegalAccessException {
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setJavascriptEnabled(true);
        caps.setPlatform(Platform.MAC);
        return new SafariDriver(caps);
    }
}
