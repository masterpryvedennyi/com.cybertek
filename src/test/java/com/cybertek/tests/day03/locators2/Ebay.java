package com.cybertek.tests.day03.locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ebay {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.name("_nkw"));
        searchBox.sendKeys("shoes" + Keys.ENTER);

        WebElement searchBttn = driver.findElement(By.id("gh-btn"));
        //searchBttn.click();
        //Verify title contains search item
        Thread.sleep(3000);
        String expectedPartialTitle = "shoes";
        String actual = driver.getTitle();
        if(actual.contains(expectedPartialTitle)){
            System.out.println("pass");
        }else{
            System.out.println();
        }


    }
}
