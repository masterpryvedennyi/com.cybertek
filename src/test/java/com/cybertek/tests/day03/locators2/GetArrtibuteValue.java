package com.cybertek.tests.day03.locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetArrtibuteValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().fullscreen();

        //I want to get a value of type attribute for username box
        //type = "text" -> getAttribute("attribute name")
        WebElement loginBox = driver.findElement(By.name("username"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginBttn = driver.findElement(By.id("wooden_spoon"));
        String valueOfType = loginBox.getAttribute("type");
        System.out.println(valueOfType);
        String valueOfButtonClass = loginBttn.getAttribute("class");
        String valueOfButtonClass1 = loginBttn.getAttribute("id");
        System.out.println("class:" + valueOfButtonClass + " id: " + valueOfButtonClass1);
        driver.close();
    }
}
