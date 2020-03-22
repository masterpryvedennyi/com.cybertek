package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void afterMethod(){ driver.quit(); }

    @Test
    public void getSelectedOption(){
        //find the element that has select tag
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //create select class using webelement
        Select dropdownList = new Select(dropdown);
        //get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        //verify selected option
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }

    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));
        //create select class
        Select states = new Select(dropdown);
        //selectByVisibleText("Iowa") - select by the text of the option
        states.selectByVisibleText("California");
        states.selectByVisibleText("Vermont");
        states.selectByVisibleText("Oregon");

        //selectByIndex - selects based on index
        states.selectByIndex(0);
        states.selectByIndex(50);

        //selectByValue - selects based on value of the attribute of the option
        states.selectByValue("KY");
        Thread.sleep(3000);
    }

    @Test
    public void getAllAvailableOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));
        //print the current selection
        System.out.println(monthList.getFirstSelectedOption().getText());

        //return all of the available options from dropdown
        List<WebElement> allOptions = monthList.getOptions();
        System.out.println("Number of months: " + allOptions.size());

        for(WebElement month: allOptions){
            System.out.println(month.getText());
        }
        //verify that months list always shows the current month as selected
        //get the current month
        String expected = LocalDate.now().getMonth().name();
        String actual = monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        //verify that months list has following values: January... December
        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        //getOptions gives me list of webelements, so allOptions is a list of webelements
        //but my expected is a list string, i have to make both Stirng list
        //i need to get list string from list of webelements
       List<String> actualMonths = new ArrayList<>();
       for(WebElement option: allOptions){
           actualMonths.add(option.getText());
       }
        Assert.assertEquals(expectedMonths, actualMonths);
    }

    @Test
    public void verifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));
        //verify tha list has 3 options
        int expectedSize = 3;
        int actualSize = list.getOptions().size();
        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");

        List<String> actualValues = new ArrayList<>();
        for(WebElement option: list.getOptions()){
            actualValues.add(option.getText());
        }
        Assert.assertEquals(actualValues, expectedValues);


    }


}
