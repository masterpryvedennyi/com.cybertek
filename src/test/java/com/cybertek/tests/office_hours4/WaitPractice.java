package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitPractice extends TestBase {

    /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123
     */


    @Test
    public void testWait(){
        driver.get("http://qa3.vytrack.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Login"));
        WebElement username = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        username.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        loginBtn.click();
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(driver.getTitle(), "Dashboard");
        WebElement accounts = driver.findElement(By.xpath("(//span[.='Accounts'])/following-sibling::span/following-sibling::a"));    ///span[.=‘Accounts’]/following-sibling::span/following-sibling::a
        wait.until(ExpectedConditions.elementToBeClickable(accounts));
        accounts.click();
        wait.until(ExpectedConditions.titleIs("All - Accounts - Customers"));
        Assert.assertEquals(driver.getTitle(), "All - Accounts - Customers");


    }
}
