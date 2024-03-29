package com.RSComponet.app.Infrastructure.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {


    public static String getObjectRepoValue(String keyName){
        String configPath = "/src/main/resources/ObjectRepo.properties";
        String sysPath = System.getProperty("user.dir");
        Properties config = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sysPath+configPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config.getProperty(keyName);
    }


    public static String getBrowserStackValue(String keyName){
        String configPath = "/src/main/resources/BrowserStack.properties";
        String sysPath = System.getProperty("user.dir");
        Properties config = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sysPath+configPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config.getProperty(keyName);
    }
}
