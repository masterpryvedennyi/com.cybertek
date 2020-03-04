package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        String expectedURL = "https://cybertek-reservation-qa.herokuapp.com/sign-in";
        if(driver.getCurrentUrl().equals(expectedURL)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("Expected URL: " + expectedURL +" but actual is " + driver.getCurrentUrl());
        }



        driver.navigate().to("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        if(driver.getCurrentUrl().contains("cybertek-reservation")){
            System.out.println("URL contains \"cybertek-reservation\"");
        }else{
            System.out.println("URL doesnt containt \"cybertek-reservation\"");
        }
        WebElement emailForm = driver.findElement(By.name("email"));
        emailForm.sendKeys("testemail@mail.ru");
        driver.findElement(By.name("password")).sendKeys("testPassword123");
        driver.findElement(By.xpath("/html/body/app-root/div/app-sign-in-page/div/div/div/div/form/div[3]/div[2]/div/div/button")).click();
        //driver.close();

    }
}
