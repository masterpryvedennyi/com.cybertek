package com.cybertek.tests.day04.xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverFactoryTest  {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        WebElement startBttn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/button"));
        startBttn.click();

    }
}
