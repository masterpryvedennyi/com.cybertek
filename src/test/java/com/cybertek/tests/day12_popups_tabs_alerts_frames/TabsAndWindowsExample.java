package com.cybertek.tests.day12_popups_tabs_alerts_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){ driver.quit(); }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        //get all the available tab titles
        Set<String> windowHandles = driver.getWindowHandles();
        //print all the window handles
        for(String windowHandle : windowHandles){
            System.out.println(windowHandle);
        }

        //get the id of current window/tab
        String currentWindow = driver.getWindowHandle();
        System.out.println("current window: " + currentWindow);

        System.out.println(" Before switching");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("New Window")){
                break;
            }
        }
        System.out.println(" After switching");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //write a utility that takes a String title
        //changes to tab with given title
        //if such title is not found, go back to original window

        //write a utility that takes a String url
        //changes to tab with given title
        //if such title is not found, go back to original window
    }
}
