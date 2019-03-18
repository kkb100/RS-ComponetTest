package com.RSComponet.app.Infrastructure.screenreader;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class ScreenShots {


    private final WebDriver driver;

    public ScreenShots(WebDriver driver) {
        this.driver = driver;
    }

    public void takeShot(String methodName) {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH); //3
        int year = cal.get(Calendar.YEAR); //2014
        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.HOUR_OF_DAY);


        String timeStamp = "-"+year+"-"+date+"-"+(month+1)+"-"+day+"-"+min+"-" +sec;
        String path = System.getProperty("user.dir");
        String path2 = "/src/main/resources/test_output/screenshots/";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File(path + path2  + methodName +timeStamp+ ".png");
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
