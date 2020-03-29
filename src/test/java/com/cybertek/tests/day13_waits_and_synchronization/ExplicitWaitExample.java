package com.cybertek.tests.day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tierDown(){ driver.quit(); }

    @Test
    public void test1TitleTest(){
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        driver.get("https://store.steampowered.com/");
        wait.until(ExpectedConditions.titleContains("Welcome to team"));
        Assert.assertEquals(driver.getTitle(), "Welcome to steam");
    }

    @Test
    public void test2WaitForVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(username));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
        Thread.sleep(4000);
    }

    @Test
    public void test3WaitForVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //give not enough time
        wait.withTimeout(Duration.ofSeconds(2));

        //waits for a given element to be visible on a page
        wait.until(ExpectedConditions.visibilityOf(username));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
        Thread.sleep(4000);
    }

    @Test
    public void test4WaitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));


        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        //wait for submit button to be clickable
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("loadingoverlay"))));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }

    @Test
    public void test4WaitForInvisible() {
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submitButton = driver.findElement(By.name("_submit"));
        userName.sendKeys("storemanager52");
        password.sendKeys("UserUser123");
        submitButton.click();

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement myCalendar = driver.findElement(By.linkText("My Calendar"));
        myCalendar.click();
        wait.until(ExpectedConditions.titleContains("My Calendar - Roma Medhurst"));
        Assert.assertEquals(driver.getTitle(), "My Calendar - Roma Medhurst");
    }


}
