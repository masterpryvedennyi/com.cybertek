package com.cybertek.tests.day07.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestsWithText {
    public static void main(String[] args) {
        /*
        open browser
        go to amazon
        search for "selenium cookbook"
        verify that there is result with text "Selenium Testing Cookbook - Second Edition"

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium cookbook" + Keys.ENTER);

        WebElement searchedItem = driver.findElement(By.xpath("//span[.=\"Selenium Testing Tools Cookbook - Second Edition\"]"));
        System.out.println(searchedItem.getText());
        if(searchedItem.isDisplayed()){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }



    }
}
