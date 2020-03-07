package com.cybertek.tests.day04.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSumbit {
    public static void main(String[] args) {
        /*
        click() VS sumbit()
        task: go to forgot pass page, enter any email
        click retrieve password button
        verify title
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().fullscreen();
        WebElement emailBox = driver.findElement(By.name("email"));
        WebElement sumbitBttn = driver.findElement(By.id("form_submit"));
        emailBox.sendKeys("testemail@gmail.com");
        emailBox.submit();
        //sumbitBttn.click();
        String expectedTitle = "Your e-mail's been sent!";
        if(driver.findElement(By.name("confirmation_message")).getText().equalsIgnoreCase(expectedTitle)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.close();









    }
}
