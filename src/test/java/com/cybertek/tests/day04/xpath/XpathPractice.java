package com.cybertek.tests.day04.xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        WebElement loginBttn = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]"));
        usernameBox.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        // Thread.sleep(5000);
        loginBttn.submit();
        driver.close();

    }
}
