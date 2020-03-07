package com.cybertek.tests.day03.locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //driver.manage().window().fullscreen();

        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        System.out.println(example3.getText());
        //example3.click();

        //I want to locate example3 with only partial link text
        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));
        System.out.println(example3_2.getText());
        //example3_2.click();

        WebElement cybertek = driver.findElement(By.partialLinkText("Cybertek School"));
        System.out.println(cybertek.getText());
        cybertek.click();

        WebElement homeLink = driver.findElement(By.linkText("Home"));
        System.out.println(homeLink.getText());

    }
}
