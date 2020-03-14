package com.cybertek.tests.day05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        System.out.println(homeLink.getText());



        driver.close();
    }
}
