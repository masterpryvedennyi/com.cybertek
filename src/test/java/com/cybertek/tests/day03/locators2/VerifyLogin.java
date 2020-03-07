package com.cybertek.tests.day03.locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        WebElement loginBox = driver.findElement(By.name("username"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginBttn = driver.findElement(By.id("wooden_spoon"));
        loginBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword");
        loginBttn.click();
        String expectedMessage = "You logged into a secure area!";
//        if(driver.findElement(By.id("flash")).getText().contains(expectedMessage)){
//            System.out.println("pass");
//        }else{
//            System.out.println("fail");
//        }
        if(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below.")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.close();
    }
}
