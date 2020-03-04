package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OfficeHours0303 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/?ref=lgo)");
        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        //findElement() -> returns WebElement
        //as param we put By.locator    (id, name, class, tag...)


    }
}
