package com.cybertek.tests.day05_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartsWith {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button4 = driver.findElement(By.xpath("$x(//button[starts-with(@id, \"_button\")])"));
        System.out.println(button4.getText());
        driver.close();
    }
}
