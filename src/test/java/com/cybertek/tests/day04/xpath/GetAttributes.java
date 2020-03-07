package com.cybertek.tests.day04.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().fullscreen();
        WebElement sumbitBttn = driver.findElement(By.id("form_submit"));
        System.out.println(sumbitBttn.getAttribute("type"));
        driver.close();
    }
}

