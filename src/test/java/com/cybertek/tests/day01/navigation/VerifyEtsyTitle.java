package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyEtsyTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();



        String etsyTitle = "https://www.etsy.com";
        driver.get(etsyTitle);
        driver.manage().window().fullscreen();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle =driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("Actual title - " + actualTitle + " and expected title - " + expectedTitle);
        }
        driver.close();
    }
}
