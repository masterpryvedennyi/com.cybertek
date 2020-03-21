package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class RadioButtonTest {
    WebDriver driver;
    /*
    go to website
    verify that blue is selected
    red is not selected

     */
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("safari");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void test1(){
        WebElement blue = driver.findElement(By.id("blue"));
        Assert.assertTrue(blue.isSelected());
        WebElement red = driver.findElement(By.id("red"));
        System.out.println(blue.isSelected());
        //verify if statement is false.
        Assert.assertFalse(red.isSelected());
        System.out.println(red.isSelected());
    }

    /*
    go to website
    click on red
    verify that blue is not selected
    red is selected
     */
    @Test
    public void test2() throws InterruptedException {
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        Thread.sleep(2000);
        Assert.assertFalse(blue.isSelected());
        Assert.assertTrue(red.isSelected());

    }
}
