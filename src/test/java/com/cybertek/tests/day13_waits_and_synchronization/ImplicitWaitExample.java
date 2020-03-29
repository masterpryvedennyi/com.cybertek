package com.cybertek.tests.day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tierDown(){ driver.quit(); }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        WebElement message = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        WebElement message1 = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(message1.isDisplayed());
        System.out.println(message1.getText());
    }
}
