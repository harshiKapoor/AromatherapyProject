package com.aromatherapy.library;

import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;

public class Utility {

    public static void captureScreenshot(WebDriver driver, String screenShotName)  {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File screenshot =  takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(screenshot,new File("./screenshots/"+screenShotName+".png"));
        } catch (IOException e) {
            System.out.println("Exception occured while taking screenshot"+ e);
        }
    }

    public static Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public static Cookie getSpecificCookie(WebDriver driver, String cookieName){
        return driver.manage().getCookieNamed(cookieName);
    }


}
