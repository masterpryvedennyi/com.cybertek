package com.cybertek.tests.day01.navigation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyEtsyURL {
    public static void main(String[] args) {
        /*
        go to etsy
        veify url
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
        driver.manage().window().fullscreen();
        String expectedURL = "https://www.etsy.com/";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual URL - " + actualURL + " and expected URL - " + expectedURL);
        }
        driver.close();


    }
}
