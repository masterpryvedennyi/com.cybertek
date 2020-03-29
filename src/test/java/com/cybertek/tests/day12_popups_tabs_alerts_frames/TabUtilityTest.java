package com.cybertek.tests.day12_popups_tabs_alerts_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabUtilityTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){ driver.quit(); }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Thread.sleep(5000);
        WebDriverFactory.goToTab("Practice");
        Thread.sleep(10000);
    }
}
