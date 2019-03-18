package com.RSComponet.app.Infrastructure.BrowserConfig;

import com.RSComponet.app.Infrastructure.filereader.ConfigReader;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;



public class RemoteCustomCapabilities {



    private String systemPath = null;
    private URL url;
    private String sauceLabFarm = "";
    private String vmOnLocalFarmUrl = "http://192.168.112.128:4445/wd/hub";
    private String USERNAME = "dan1135";
    private String AUTOMATE_KEY = "RyR8B5KfghfdfKsmRfm";
    private String browserStackFarmUrl = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public RemoteCustomCapabilities(String remotePlace) throws MalformedURLException {
        this.systemPath = System.getProperty("user.dir");
        if(remotePlace.contains("browserstack")){
            url = new URL(browserStackFarmUrl);
        }else if(remotePlace.contains("localFarm")) {
            url = new URL(vmOnLocalFarmUrl);
        }else if(remotePlace.contains("saucelab")) {
            url = new URL(sauceLabFarm);
        }
    }

    public WebDriver getFirefoxDriver() throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
       // profile.setEnableNativeEvents(true);
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability(FirefoxDriver.PROFILE, profile);

        String browserName  = ConfigReader.getBrowserStackValue("BrowserName");
        String browserVersion  = ConfigReader.getBrowserStackValue("BrowserVersion");
        String osType  = ConfigReader.getBrowserStackValue("OSType");
        String osVersion  = ConfigReader.getBrowserStackValue("OSVersion");
        String screenResolution  = ConfigReader.getBrowserStackValue("ScreenResolution");


        caps.setCapability("browser", browserName);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", osType);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("resolution", screenResolution);
        caps.setCapability("build", "5");
        caps.setJavascriptEnabled(true);
        caps.setCapability("marionette", true);

        return new RemoteWebDriver(url, caps);
    }



    public WebDriver getIEDriver(){
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setBrowserName("internet explorer");
        caps.setPlatform(Platform.WIN10);
        caps.setJavascriptEnabled(true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        return new RemoteWebDriver(url, caps);
    }

    public WebDriver getChromeDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        String browserName  = ConfigReader.getBrowserStackValue("BrowserName");
        String browserVersion  = ConfigReader.getBrowserStackValue("BrowserVersion");
        String osType  = ConfigReader.getBrowserStackValue("OSType");
        String osVersion  = ConfigReader.getBrowserStackValue("OSVersion");
        String screenResolution  = ConfigReader.getBrowserStackValue("ScreenResolution");

        caps.setCapability("browser", browserName);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", osType);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("resolution", screenResolution);
        caps.setCapability("build", "5");
        caps.setJavascriptEnabled(true);

        return new RemoteWebDriver(url, caps);
    }




    public WebDriver getMicrosoftEdgeDriver() {
        DesiredCapabilities caps = DesiredCapabilities.edge();
        caps.setBrowserName("MicrosoftEdge");
        caps.setPlatform(Platform.WIN10);
        caps.setJavascriptEnabled(true);
        return new RemoteWebDriver(url, caps);
    }
}
