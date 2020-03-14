package com.cybertek.tests.day06.css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(button.getText());
        WebElement result = driver.findElement(By.cssSelector(".col-4.col-md-4"));
        System.out.println(result.getText());
    }
}
