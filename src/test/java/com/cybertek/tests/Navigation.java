package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //I want to see the full window
        driver.manage().window().fullscreen();

        String practiceURL = "http://practice.cybertekschool.com";
        String googleURL = "https://www.google.com";
        driver.get(practiceURL);

        driver.navigate().to(googleURL);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        driver.get(practiceURL);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //closes just 1 tab in the browser
        driver.close();

        //closes all tabs in the browser
        //driver.quit();




    }
}
