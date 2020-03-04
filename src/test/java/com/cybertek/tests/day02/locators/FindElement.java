package com.cybertek.tests.day02.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //Locator 1. ID
        driver.get("https://cybertekschool.okta.com/");//https://cybertekschool.okta.com/
        WebElement userNameField = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        userNameField.sendKeys("pryvedennyi@gmail.com");
        passwordField.sendKeys("testPassword");
        signInButton.click();

        //id="okta-signin-username"
    }
}
