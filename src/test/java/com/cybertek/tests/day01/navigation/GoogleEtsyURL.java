package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleEtsyURL {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();




        driver.get("https://www.google.com");
        String googleTitle = driver.getTitle();
        driver.get("https://www.etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(5000);
        if(driver.getTitle().equals(googleTitle)){
            System.out.println("Google Title PASS");
        }else{
            System.out.println("Google Title FAIL");
        }
        driver.navigate().forward();
        Thread.sleep(3000);
        if(driver.getTitle().equals(etsyTitle)){
            System.out.println("Etsy URL PASS");
        }else{
            System.out.println("Etsy URL FAIL");
        }
        driver.close();
    }
}
