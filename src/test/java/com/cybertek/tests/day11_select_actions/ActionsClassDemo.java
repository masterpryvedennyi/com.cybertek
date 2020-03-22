package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassDemo {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);

    }

    @AfterMethod
    public void afterMethod(){ driver.quit(); }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement target = driver.findElement(By.tagName("img"));

        //moveToElement - moves mouse to provided element
        actions.moveToElement(target);
        Thread.sleep(4000);
    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        actions.pause(3000);
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        //move the mouse to enabled
        //wait
        //move mouse to downloads
        //wait
        //click on pdf
        actions.moveToElement(enabled).pause(2000).moveToElement(downloads).pause(2000).click(pdf).build().perform();
        Thread.sleep(4000);
        }

        @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(money, bank).perform();
        Thread.sleep(4000);

        }
}
