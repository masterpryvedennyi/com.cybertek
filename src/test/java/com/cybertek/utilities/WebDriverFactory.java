package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Set;

public class WebDriverFactory {
    static WebDriver driver;
    // write a return method which returns webdriver
    public static WebDriver getDriver(String browser) {
        driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        return driver;
    }

    public static void goToTab(String title){
        Set<String> windowHandles = driver.getWindowHandles();
        //print all the window handles

        //get the id of current window/tab
        String currentWindow = driver.getWindowHandle();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(title)){
                break;
            }
        }
    }


}
