package com.cybertek.tests.day03.locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;

public class VerifyErrorMessage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        WebElement loginBox = driver.findElement(By.name("username"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginBttn = driver.findElement(By.id("wooden_spoon"));
        Faker fakeData = new Faker();
        String username = fakeData.name().username();
        String password = fakeData.number().digits(4);
        loginBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBttn.click();
        String expectedError = "Your username is invalid!";
        if(driver.findElement(By.id("flash")).getText().contains(expectedError)){
            System.out.println("pass");
        }else{
            System.out.println("fail! user is able to login with invalid username and password");
        }
        driver.close();

    }
}
