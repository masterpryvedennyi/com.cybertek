package com.cybertek.tests.day12_popups_tabs_alerts_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlertExamples {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){ driver.quit(); }

    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        button.click();
        Thread.sleep(1000);
        WebElement noButton = driver.findElement(By.id("j_idt720:j_idt724"));
        noButton.click();
        Thread.sleep(1000);
    }

    @Test
    public void jsAlertsAccept() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void jsAlertCancel() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[2]"));
        button.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(2000);
    }

    @Test
    public void jsAlertSendKeys() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[3]"));
        //button.click();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
            alert.sendKeys("bla bla");
            alert.accept();

        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        //we will switch to iframe element
        //TODO switch by id/name
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great. thanks");
        Thread.sleep(3000);
        //TODO get out of the frame
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by webelement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        //textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great. thanks 2 times");
        Thread.sleep(3000);

        //TODO get out of the frame
        driver.switchTo().parentFrame();

        //TODO switch by index
        driver.switchTo().frame(0);
        textBox.clear();
        textBox.sendKeys("great. thanks last time");
        Thread.sleep(3000);



    }

}
