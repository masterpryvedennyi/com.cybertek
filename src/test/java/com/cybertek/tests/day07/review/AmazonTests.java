package com.cybertek.tests.day07.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTests {
    public static void main(String[] args) throws InterruptedException {
        nameMatchTest();
        secondNameMatch();

    }
        //each test will be a separate method

    /*
    open browser
    go to amazon
    search any item
    remenber the name of the first result
    click on th first result

     */
        private static void nameMatchTest() throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://www.amazon.com");

            String searchTerm = "disinfectant wipes";
            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            searchInput.sendKeys(searchTerm + Keys.ENTER);

            WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            String expectedName = firstResult.getText();
            firstResult.click();
            Thread.sleep(4000);
            WebElement productName = driver.findElement(By.id("productTitle"));
            String actualName = productName.getText();

            if(expectedName.equals(actualName)){
                System.out.println("pass");
            }else{
                System.out.println("fail");
                System.out.println("expected name" + expectedName);
                System.out.println("actual name" + actualName);
            }
            driver.close();
        }
        private static void secondNameMatch() throws InterruptedException{
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://www.amazon.com");

            String searchTerm = "disinfectant wipes";
            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            searchInput.sendKeys(searchTerm + Keys.ENTER);

            WebElement secondResult = driver.findElement(By.xpath("(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[2]"));
            String expectedName = secondResult.getText();
            secondResult.click();
            Thread.sleep(4000);
            WebElement productName = driver.findElement(By.id("productTitle"));
            String actualName = productName.getText();

            if(expectedName.equals(actualName)){
                System.out.println("pass");
            }else{
                System.out.println("fail");
                System.out.println("expected name" + expectedName);
                System.out.println("actual name" + actualName);
            }
            driver.close();
        }

}
