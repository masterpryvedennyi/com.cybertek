package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpTests() {
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
    }

    @Test
    public void wrongUsernameTest(){
        //driver.get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys("user3000");
        loginPage.password.sendKeys("UserUser123");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void wrongPasswordTest(){
        loginPage.username.sendKeys("SalesManager110");
        loginPage.password.sendKeys("LC");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
}
