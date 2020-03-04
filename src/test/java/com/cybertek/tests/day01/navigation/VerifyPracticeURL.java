package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyPracticeURL {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().fullscreen();
        String expectedURL = "http://practice.cybertekschool.com/";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual URL - " + actualURL + " and expected URL - " + expectedURL);
        }
        driver.close();
    }
}
