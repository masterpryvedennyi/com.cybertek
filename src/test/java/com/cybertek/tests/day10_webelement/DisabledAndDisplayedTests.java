package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledAndDisplayedTests {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void disabledTest() throws InterruptedException {
        /*
        verify green is disabled
        verify black is enabled
         */
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());

        //verify that certain element is equal to null. verify element is enabled
        Thread.sleep(2000);
        Assert.assertEquals(black.getAttribute("disabled"), null);
        Assert.assertNull(black.getAttribute("disabled"));

        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));
    }

    @Test
    public void testElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));
        //verify username is not visible
        //isDisplayed - returns true element we found in html is visible on page

        System.out.println("Username is visible: " + username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());

        System.out.println("click on start");
        start.click();
        Thread.sleep(5000);
        System.out.println("Username is visible: " + username.isDisplayed());
        Assert.assertTrue(username.isDisplayed());
    }
}
