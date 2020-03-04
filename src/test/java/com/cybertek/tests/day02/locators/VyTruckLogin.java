package com.cybertek.tests.day02.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class VyTruckLogin {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submitButton = driver.findElement(By.name("_submit"));
        userName.sendKeys("storemanager52");
        password.sendKeys("UserUser123");
        WebElement checkBox = driver.findElement(By.className("custom-checkbox__icon"));
        //checkBox.click();
        submitButton.submit();
        Thread.sleep(5000);
        String expectedTitle = "Dashboard";
        if(driver.getTitle().equals(expectedTitle)){
            System.out.println("User is successfully logged in and home page is loaded");
        }else{
            throw new Exception("Page is not loaded");
        }

    }
}
