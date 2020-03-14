package com.cybertek.tests.day04.xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/context_menu");
        WebElement header = driver.findElement(By.xpath("//h3[text()=\"Context Menu\"]"));
        String expectedContextMenu = "Context Menu";
        if(header.getText().equals(expectedContextMenu)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.close();
    }
}
