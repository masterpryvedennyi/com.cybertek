package com.cybertek.tests.day02.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackingLoginNegative {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submitButton = driver.findElement(By.name("_submit"));
        userName.sendKeys("storemanager520");
        password.sendKeys("UserUser1230");
        submitButton.click();
        Thread.sleep(5000);
        String expectedTitle = "Dashboard";
        if(driver.getTitle().equals(expectedTitle)){
            throw new Exception("Page is loaded with invalid credentials!!!");
        }else{
            System.out.println("Pass");
            System.out.println("User was not able to log in");
        }
    }
}
