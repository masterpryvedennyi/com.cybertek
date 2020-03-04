package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        //connect browser and driver, setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*
        1. Go to cybertek practice web site
        2. Verify Title     expected result: Practice
         */
        String practiceURL = "http://practice.cybertekschool.com";
        driver.get(practiceURL);
        driver.manage().window().fullscreen();
        String expectedTitle = "Practiced";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("Expected title - " + expectedTitle + " and actual title is - " + actualTitle);
        }
        driver.close();


    }
}
