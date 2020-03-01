package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException{
        //binary the driver and browsers
        WebDriverManager.chromedriver().setup();


        //WebDriver object needs to be created
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com");
        //driver.close();

        //get() vs navigate().to();
        //get() - wait for page to load
        //navigate - doesnt wait for elements to load

        //driver.navigate().to("https://www.google.com");

        //driver.navigate().to("http://practice.cybertekschool.com");
        //go to the previous page
        //driver.navigate().back();
        //Thread.sleep(3000);
        driver.get("http://practice.cybertekschool.com");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.close();




    }
}
