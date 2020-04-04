package com.cybertek.tests.day05_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement buttonOne = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button[1]"));
        WebElement buttonTwo = driver.findElement(By.xpath("//button[2]"));
        WebElement buttonThree = driver.findElement(By.xpath("//button[@onclick=\'button3()\'"));
        WebElement buttonFour = driver.findElement(By.xpath("//button[contains(text(),'utton 4'"));
        WebElement buttonFive = driver.findElement(By.xpath("//h3/following-sibling::button[5]"));
        WebElement buttonSix = driver.findElement(By.xpath("//button[@id='disappearing_button']"));

    }
}
