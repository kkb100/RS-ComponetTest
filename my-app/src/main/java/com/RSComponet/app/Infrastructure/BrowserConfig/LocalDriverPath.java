package com.RSComponet.app.Infrastructure.BrowserConfig;


public class LocalDriverPath {

    private String systemPath;

    public LocalDriverPath() {
        this.systemPath = System.getProperty("user.dir");
    }

    public String getFirefoxDriverPath(String machineType) throws IllegalAccessException{
        if(machineType.toLowerCase().contains("linux")){
            return systemPath+"/drivers-package/linux/firefox/geckodriver";
        }else if(machineType.toLowerCase().contains("window")){
            return  systemPath+"\\drivers-package\\windows\\firefox\\geckodriver.exe";
        }else if(machineType.toLowerCase().contains("macosx")){
            return systemPath+"/drivers-package/macosx/firefox/geckodriver";
        }else{
            throw new IllegalAccessException("There is no such machine programmed on this test framework");
        }
    }


    public String getInternetExplorerDriverPath(String machineType) throws IllegalAccessException {
        if(machineType.toLowerCase().contains("window")){
            return systemPath+"\\drivers-package\\windows\\internet-explorer\\IEDriverServer.exe";
        }else{
            throw new IllegalAccessException("There is no such machine programmed on this test framework");
        }
    }

    public String getChromeDriverPath(String machineType) throws IllegalAccessException {
        if(machineType.toLowerCase().contains("linux")){
            return systemPath+"/drivers-package/linux/chrome/chromedriver";
        }else if(machineType.toLowerCase().contains("window")){
            return systemPath+"\\drivers-package\\windows\\chrome\\chromedriver.exe";
        }else if(machineType.toLowerCase().contains("macosx")){
            return systemPath+"/drivers-package/macosx/chrome/chromedriver";
        }else{
            throw new IllegalAccessException("There is no such machine programmed on this test framework");
        }
    }

    public String getPhantomJsDriverPath(String machineType) throws IllegalAccessException {
        if(machineType.toLowerCase().contains("linux")){
            return systemPath+"/drivers-package/linux/phantomjs/phantomjs-2.1.1-linux-x86_64/bin/phantomjs";
        }else if(machineType.toLowerCase().contains("window")){
            return  systemPath+"\\drivers-package\\windows\\phantomjs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
        }else if(machineType.toLowerCase().contains("macosx")){
            return systemPath+"/drivers-package/macosx/phantomjs/phantomjs-2.1.1-macosx/bin/phantomjs";
        }else{
            throw new IllegalAccessException("There is no such machine programmed on this test framework");
        }
    }

    public String getEdgeDriverPath(String machineType) throws IllegalAccessException {
        if(machineType.toLowerCase().contains("window")){
            return systemPath+"\\drivers-package\\windows\\microsoft-edge\\MicrosoftWebDriver.exe";
        }else{
            throw new IllegalAccessException("There is no such machine programmed on this test framework");
        }
    }



}
