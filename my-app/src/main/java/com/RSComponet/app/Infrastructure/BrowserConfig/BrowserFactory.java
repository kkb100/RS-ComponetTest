package com.RSComponet.app.Infrastructure.BrowserConfig;


import com.RSComponet.app.Infrastructure.filereader.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class BrowserFactory {


    protected static WebDriver driver;

    public WebDriver setUpBrowser(String browserName, String executionArea, String machineType, String remotePlace) throws Throwable {
        if(executionArea.equalsIgnoreCase("local")){
            setUpBrowserOnLocalMachine(browserName, machineType);
        }else if(executionArea.equalsIgnoreCase("remote")){
            setUpBrowserOnRemoteMachine(browserName, remotePlace);
        }else{
            throw new IllegalAccessException("There is no such environment to run the test");
        }
        this.prepareBrowser();
        return driver;
    }

    private void setUpBrowserOnRemoteMachine(String browserName, String remotePlace) throws MalformedURLException {
        RemoteCustomCapabilities remoteCaps = new RemoteCustomCapabilities(remotePlace);
        if(browserName.equalsIgnoreCase("firefox")){
            driver = remoteCaps.getFirefoxDriver();
        }else if(browserName.equalsIgnoreCase("internet explorer")){
            driver = remoteCaps.getIEDriver();
        }else if(browserName.equalsIgnoreCase("microsoft edge")){
            driver = remoteCaps.getMicrosoftEdgeDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            driver = remoteCaps.getChromeDriver();
        }else{
            System.out.println("");
        }
    }

    private void setUpBrowserOnLocalMachine(String browserName, String machineType) throws IllegalAccessException {
        LocalCustomCapabilities localcaps = new LocalCustomCapabilities();
        if(browserName.equalsIgnoreCase("firefox")){
            driver = localcaps.getFirefoxDriver(machineType);
        }else if(browserName.equalsIgnoreCase("internet explorer")){
            driver = localcaps.getIEDriver(machineType);
        }else if(browserName.equalsIgnoreCase("microsoft edge")){
            driver = localcaps.getMicrosoftEdgeDriver(machineType);
        }else if(browserName.equalsIgnoreCase("chrome")){
            driver = localcaps.getChromeDriver(machineType);
//        }else if(browserName.equalsIgnoreCase("phantomjs")){
//            driver = localcaps.getPhantonJsDriver(machineType);
        }else if(browserName.equalsIgnoreCase("htmlUnit")){
            driver = localcaps.getHtmlChromeUnitDriver(machineType);
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = localcaps.getSafariDriver();
        }
    }




    private void prepareBrowser(){
        driver.manage().window().maximize();
        long defaultTime = Long.parseLong(ConfigReader.getObjectRepoValue("rscomponent.dev.default.time"));
        driver.manage().timeouts().implicitlyWait(defaultTime, TimeUnit.SECONDS);
    }

    public void tearDownBrowser(){
        if(driver != null)
            driver.quit();
    }


    public static WebDriver getDriver(){
        return driver;
    }
}
