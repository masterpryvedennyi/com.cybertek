package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTests() {
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        wait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage();
    }

    @Test
    public void loginAsDrivers(){
        loginPage.login("driver_username", "driver_password");
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Dashboard");
    }

    @Test
    public void loginAsSalesManger(){
        loginPage.login("sales_manager_username", "sales_manager_password");
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Dashboard");
    }

    @Test
    public void loginAsStoreManger(){
        loginPage.login("store_manager_username", "store_manager_password");
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Dashboard");
    }
}
